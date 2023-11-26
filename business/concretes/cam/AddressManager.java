package com.beymen.business.concretes.cam;

import com.beymen.core.utilities.mapping.IModelMapperService;
import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.repository.abstracs.cam.IAddressRepository;
import com.beymen.business.abstracts.cam.IAddressService;
import com.beymen.business.constant.Messages;
import com.beymen.business.dtos.requests.address.AddressDeletedRequest;
import com.beymen.business.dtos.requests.address.AddressUpdatedRequest;
import com.beymen.business.dtos.requests.address.CreateAddressWithCustomerRequest;
import com.beymen.business.dtos.responses.address.AddressUpdatedResponse;
import com.beymen.business.dtos.responses.address.CreateAddressWithCustomerResponse;
import com.beymen.core.utilities.Enum.ActivationStatus;
import com.beymen.core.utilities.Enum.TypeValues;
import com.beymen.core.utilities.expection.business.BusinessException;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.Result;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.core.utilities.results.SuccessResult;
import com.beymen.entities.concretes.cam.Addr;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class AddressManager implements IAddressService {
    private IAddressRepository iAddressRepository;
    private IModelMapperService modelMapperService;
    private IMessageSourceService messageSourceService;

    @Override
    public DataResult<List<Addr>> getAll() {

        return new SuccessDataResult<List<Addr>>(this.iAddressRepository.findAll(),messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
    public DataResult<Page<List<Addr>>> findAllWithPagination(Pageable pageable) {

        Page<List<Addr>> response=this.iAddressRepository.getAllWithPagination(pageable);

        return new SuccessDataResult<>(response,messageSourceService.getMessages(Messages.SuccessMessages.GetAllWithPagination));
    }

    @Override
    public Result deleteAddress(AddressDeletedRequest addressDeletedRequest) {

        Addr addr = findByIdAddress(addressDeletedRequest.getAddressId());

        addr.setIsActv(ActivationStatus.INACTIVE); //Aktiflik bilgisi!

        this.iAddressRepository.delete(addr);

        return new SuccessResult(messageSourceService.getMessages(Messages.SuccessMessages.Deleted));
    }


    //Update İşlemleri sorunsuz çalışıyor
    @Override
    public DataResult<List<AddressUpdatedResponse>> updateAddress(AddressUpdatedRequest addressUpdatedRequest) {

        Addr address = findByIdAddress(addressUpdatedRequest.getAddrId());

        //Address gereksinimleri Set edildi
        address.setCityName(addressUpdatedRequest.getCity());
        address.setBldgId(addressUpdatedRequest.getBldgId());
        address.setStrtName(addressUpdatedRequest.getStreet());
        address.setAddrDesc(addressUpdatedRequest.getAddressDescription());
        address.setCntryName(addressUpdatedRequest.getCountryName());

        //Updatenin kayıt alanı
        Addr savedAddress = iAddressRepository.save(address);

        //Kaydedilen address responseye maplendi
        AddressUpdatedResponse response = modelMapperService.getMapperResponse().map(savedAddress, AddressUpdatedResponse.class);

        List<AddressUpdatedResponse> responses = new ArrayList<>();

        responses.add(response);

        return new SuccessDataResult<>(responses,messageSourceService.getMessages(Messages.SuccessMessages.Updated));
    }

    @Override
    public DataResult<CreateAddressWithCustomerResponse> createAddressForCustomer
            (CreateAddressWithCustomerRequest createAddressWithCustomerRequest) {

        Addr addr = addrBuilder(createAddressWithCustomerRequest);

        this.iAddressRepository.save(addr);

        CreateAddressWithCustomerResponse response = createAddressWithCustomerResponseBuilder(addr);

        return new SuccessDataResult<>(response,messageSourceService.getMessages(Messages.SuccessMessages.Created));
    }


    private Addr addrBuilder(CreateAddressWithCustomerRequest createAddressWithCustomerRequest){

        return Addr.builder()
                .cityName(createAddressWithCustomerRequest.getCity())
                .addrDesc(createAddressWithCustomerRequest.getAddressDescription())
                .bldgId(createAddressWithCustomerRequest.getBldgId())
                .isActv(ActivationStatus.ACTIVE) //Kullanıcı aktiflik bilgisi
                .strtName(createAddressWithCustomerRequest.getStreet())
                .dataTpId(TypeValues.PARTY)  //Kullancının Parti Bilgisi = 9L
                .rowId(createAddressWithCustomerRequest.getRowId())
                .cntryName(createAddressWithCustomerRequest.getCountry())
                .build();
    }

    private CreateAddressWithCustomerResponse createAddressWithCustomerResponseBuilder(Addr addr){
        return  CreateAddressWithCustomerResponse.builder()
                .addressDescription(addr.getAddrDesc())
                .city(addr.getCityName())
                .bldgId(addr.getBldgId())
                .street(addr.getStrtName())
                .country(addr.getCntryName())
                .build();
    }

    public Addr findByIdAddress(Long addrId){
        return this.iAddressRepository.findById(addrId).orElseThrow(
                ()-> new BusinessException(messageSourceService.getMessages(Messages.ErrorMessages.NotFound)));
    }

    private List<Addr> findByRowId(Long rowId) {
        return this.iAddressRepository.findByRowId(rowId);
    }

}
