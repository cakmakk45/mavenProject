package com.beymen.business.concretes.cam;

import com.beymen.business.abstracts.cam.*;
import com.beymen.business.dtos.requests.contactMedium.ContactMediumUpdatedRequest;
import com.beymen.business.dtos.requests.customer.CreateCustomerRequest;
import com.beymen.business.dtos.requests.customer.FilteredCustomerRequest;
import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.ErrorDataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.repository.abstracs.cam.ICustomerRepsoitory;
import com.etiya.crmlite.business.abstracts.cam.*;
import com.beymen.business.constant.Messages;
import com.beymen.business.dtos.requests.address.CreateAddressWithCustomerRequest;
import com.beymen.business.dtos.responses.address.CreateAddressWithCustomerResponse;
import com.beymen.business.dtos.responses.customer.CreateCustomerResponse;
import com.beymen.business.dtos.responses.customer.DeleteCustomerResponse;
import com.beymen.business.dtos.responses.customer.FilterCustomerResponse;
import com.beymen.core.utilities.Enum.CustomerTypes;
import com.beymen.core.utilities.Enum.StatusCode;
import com.etiya.crmlite.core.utilities.results.*;
import com.beymen.entities.concretes.cam.Cust;
import com.beymen.entities.concretes.cam.Ind;
import com.beymen.entities.concretes.cam.Party;
import com.beymen.entities.concretes.cam.Party_Role;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements ICustomerService {
    private ICustomerRepsoitory iCustomerRepsoitory;

    private IMessageSourceService messageSourceService;

    private IIndividualService individualService;
    private ICustomerTypeService customerTypeService;
    private IPartyRoleService partyRoleService;

    private IPartyService partyService;
    private IAddressService addressService;
    private IContactMediumService contactMediumService;


    @Override
    public DataResult<List<Cust>> getAll() {
        return new SuccessDataResult<>(this.iCustomerRepsoitory.findAll());
    }

    public DataResult<Page<List<Cust>>> findAllWithPagination(Pageable pageable) {
        Page<List<Cust>> response = this.iCustomerRepsoitory.getAllWithPagination(pageable);
        return new SuccessDataResult<>(response, messageSourceService.getMessages(Messages.SuccessMessages.GetAllWithPagination));
    }

    @Override
    @Transactional
    public DataResult<CreateCustomerResponse> createCustomer(CreateCustomerRequest createCustomerRequest) {
        Ind ind = this.individualService.createIndividual(createCustomerRequest);

        Cust cust = custBuilder();

        Party_Role party_role = partyRoleService.createPartyRole(cust);
        Party createdParty = partyService.createParty(ind, party_role);
        Party savedParty = partyService.addParty(createdParty);


        ind.setParty(savedParty);
        individualService.addInd(ind);

        party_role.setParty(savedParty);
        Party_Role savedPartyRole = partyRoleService.addPartyRole(party_role);

        cust.setPartyRole(savedPartyRole);
        iCustomerRepsoitory.save(cust);

        CreateAddressWithCustomerRequest createAddressWithCustomerRequest =
                createAddressWithCustomerRequestBuilder(createCustomerRequest, savedParty.getPartyId());
        addressService.createAddressForCustomer(createAddressWithCustomerRequest);

        ContactMediumUpdatedRequest contactMediumUpdatedRequest =
                contactMediumUpdatedRequestBuilder(createCustomerRequest, savedParty.getPartyId());

        contactMediumService.contactMediumUpdateCustomer(contactMediumUpdatedRequest);


        CreateCustomerResponse response = CreateCustomerResponseBuilder(createCustomerRequest, cust);
        return new SuccessDataResult<>(response, messageSourceService.getMessages(Messages.SuccessMessages.Created));
    }

    @Override
    public DataResult<List<FilterCustomerResponse>> filteredCustomer(FilteredCustomerRequest filteredCustomerRequest) {

        List<FilterCustomerResponse> custList = this.iCustomerRepsoitory.filteredCustomer(filteredCustomerRequest.getNationalId(), filteredCustomerRequest.getCustomerId(),
                filteredCustomerRequest.getCustAccountNumber(), filteredCustomerRequest.getGsmNumber(), filteredCustomerRequest.getFirstName(), filteredCustomerRequest.getLastName(),
                filteredCustomerRequest.getCustOrderNumber());


        List<FilterCustomerResponse> responses = custList.stream().map(result -> FilterCustomerResponse.builder()
                        .nationalityId(result.getNationalityId())
                        .customerId(result.getCustomerId())
                        .firstName(result.getFirstName())
                        .lastName(result.getLastName())
                        .roleName(result.getRoleName()).build())
                .collect(Collectors.toList());


        return checkIfCustomerExists(custList, responses);
    }

    @Override
    public DataResult<List<DeleteCustomerResponse>> deleteCustomer(Long customerId) {

        // Kullanılacak ID'ler 436,164

        List<DeleteCustomerResponse> customers = this.iCustomerRepsoitory.deletedCustomer(customerId);
        System.out.println(customers);
        List<DeleteCustomerResponse> responses = customers.stream().map(result -> DeleteCustomerResponse.builder()
                .productName(result.getProductName())
                .accountNumber(result.getAccountNumber())
                .isActv(result.getIsActv()).build()).collect(Collectors.toList());

        return checkIfCustomerHasActiveProd(customers, responses, customerId);
    }

    private Cust custBuilder() {
        return Cust.builder()
                .custTp(customerTypeService.findById(CustomerTypes.PRVT))
                .stId(StatusCode.CUST_ACTV)
                .build();
    }


    private ContactMediumUpdatedRequest contactMediumUpdatedRequestBuilder(CreateCustomerRequest createCustomerRequest, Long rowId) {
        return ContactMediumUpdatedRequest.builder()
                .rowId(rowId)
                .mobilePhone(createCustomerRequest.getMobilePhone())
                .eMail(createCustomerRequest.getEmail())
                .fax(createCustomerRequest.getFax())
                .homePhone(createCustomerRequest.getHomePhone())
                .build();
    }

    private CreateAddressWithCustomerRequest createAddressWithCustomerRequestBuilder(CreateCustomerRequest createCustomerRequest, Long rowId) {
        return CreateAddressWithCustomerRequest.builder()
                .rowId(rowId)
                .addressDescription(createCustomerRequest.getCreateAddressWithCustomerRequest().getAddressDescription())
                .city(createCustomerRequest.getCreateAddressWithCustomerRequest().getCity())
                .bldgId(createCustomerRequest.getCreateAddressWithCustomerRequest().getBldgId())
                .country(createCustomerRequest.getCreateAddressWithCustomerRequest().getCountry())
                .street(createCustomerRequest.getCreateAddressWithCustomerRequest().getStreet())
                .build();
    }


    private DataResult<List<DeleteCustomerResponse>> checkIfCustomerHasActiveProd(List<DeleteCustomerResponse> customers, List<DeleteCustomerResponse> responses, Long customerId) {

        if (customers.size() != 0) {

            return new ErrorDataResult<>(responses, messageSourceService.getMessages(Messages.CustomerMessages.customerHasActiveProd));
        } else {
            // Silme işlemi simüle edildi . Tam olarak teyit edilmedi!!!
            this.iCustomerRepsoitory.deleteById(customerId);

            return new SuccessDataResult<>(responses, messageSourceService.getMessages(Messages.SuccessMessages.Deleted));
        }
    }


    private DataResult<List<FilterCustomerResponse>> checkIfCustomerExists(List<FilterCustomerResponse> customerList,
                                                                           List<FilterCustomerResponse> responses) {

        //75395189 -- National Identity!  -- Customer Id = 403 !

        if (customerList.size() == 0) {
            return new ErrorDataResult<>(null, messageSourceService.getMessages(Messages.CustomerMessages.customerNotFound));
        }
        return new SuccessDataResult<>(responses, messageSourceService.getMessages(Messages.SuccessMessages.filteredCustomer));

    }


    private CreateCustomerResponse CreateCustomerResponseBuilder(CreateCustomerRequest createCustomerRequest, Cust createCust) {
        CreateAddressWithCustomerResponse addressResponse = CreateAddressWithCustomerResponse.builder()
                .addressDescription(createCustomerRequest.getCreateAddressWithCustomerRequest().getAddressDescription())
                .city(createCustomerRequest.getCreateAddressWithCustomerRequest().getCity())
                .bldgId(createCustomerRequest.getCreateAddressWithCustomerRequest().getBldgId())
                .country(createCustomerRequest.getCreateAddressWithCustomerRequest().getCountry())
                .street(createCustomerRequest.getCreateAddressWithCustomerRequest().getStreet())
                .build();

        CreateCustomerResponse response = CreateCustomerResponse.builder()
                .customerId(createCust.getCustId())
                .firstName(createCustomerRequest.getFirstName())
                .lastName(createCustomerRequest.getLastName())
                .birthDate(createCustomerRequest.getBirthDate())
                .gender(createCustomerRequest.getGender())
                .nationalityId(Long.parseLong(createCustomerRequest.getNationalityId()))
                .createAddressWithCustomerResponse(addressResponse)
                .email(createCustomerRequest.getEmail())
                .email(createCustomerRequest.getEmail())
                .mobilePhone(createCustomerRequest.getMobilePhone())
                .build();

        return response;
    }


}
