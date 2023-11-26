package com.beymen.business.concretes.cam;

import com.beymen.business.dtos.requests.customer.CustomerAccountBillRequest;
import com.beymen.business.dtos.requests.customer.CustomerAccountBillUpdateRequest;
import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.repository.abstracs.cam.ICustomerAccountRepository;
import com.beymen.business.abstracts.cam.IAddressService;
import com.beymen.business.abstracts.cam.ICustomerAccountService;
import com.beymen.business.constant.Messages;
import com.beymen.business.dtos.responses.address.CreateAddressWithCustomerResponse;
import com.beymen.business.dtos.responses.customer.CustomerAccountBillResponse;
import com.beymen.core.utilities.Enum.GeneralTypes;
import com.beymen.core.utilities.Enum.StatusCode;
import com.beymen.core.utilities.expection.business.BusinessException;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.cam.Cust;
import com.beymen.entities.concretes.cam.Cust_Acct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CustomerAccountManager implements ICustomerAccountService {
    private ICustomerAccountRepository iCustomerAccountRepository;

    private IAddressService iAddressService;
    private IMessageSourceService messageSourceService;
    @Override
    public DataResult<List<Cust_Acct>> getAll() {
        return new SuccessDataResult<>(this.iCustomerAccountRepository.findAll(),messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }

    @Override
    public DataResult<CustomerAccountBillResponse> customerAccountBillCreated(CustomerAccountBillRequest customerAccountBillRequest) {
        Cust cust = new Cust();
        CheckCustomer(customerAccountBillRequest.getCustomerId());
        //TODO:CUST ID YAZINCA ROW ID OLACAK
        DataResult<CreateAddressWithCustomerResponse> adressResponse=iAddressService.createAddressForCustomer(customerAccountBillRequest.getCreateAddressWithCustomerRequest());
        cust.setCustId(customerAccountBillRequest.getCustomerId());
        Cust_Acct cust_acct =Cust_Acct.builder()
                .cust(cust)
                .acctName(customerAccountBillRequest.getAccountName())
                .acctNo("262626")
                .stId(StatusCode.CUST_ACC_ACTV)
                .acctTpId(GeneralTypes.BILL_ACCT)
                .descr(customerAccountBillRequest.getAccountDescription())
                .build();
            this.iCustomerAccountRepository.save(cust_acct);

        CustomerAccountBillResponse response = CustomerAccountBillResponse.builder()
                .accountDescription(cust_acct.getDescr())
                .accountName(cust_acct.getAcctName())
                .customerId(cust_acct.getCustAcctId())
                .createAddressWithCustomerResponse(adressResponse.getData())
                .build();
        return  new SuccessDataResult<>(response,messageSourceService.getMessages(Messages.SuccessMessages.Created));
    }

    @Override
    public DataResult<CustomerAccountBillResponse> customerAccountBillUpdeted
            (CustomerAccountBillUpdateRequest customerAccountBillUpdateRequest)
    {
       Cust_Acct cust_acct = this.iCustomerAccountRepository.findById(customerAccountBillUpdateRequest.getCustomerAccountId())
               .orElseThrow( ()-> new BusinessException(messageSourceService.getMessages(Messages.ErrorMessages.NotFound)));

        Cust cust = new Cust();

        DataResult<CreateAddressWithCustomerResponse> adressResponse=iAddressService
                .createAddressForCustomer(customerAccountBillUpdateRequest.getCreateAddressWithCustomerRequest());

        cust.setCustId(customerAccountBillUpdateRequest.getCustomerId());

        CheckCustomer(customerAccountBillUpdateRequest.getCustomerId());

        Cust_Acct custAcct =Cust_Acct.builder()
                .custAcctId(cust_acct.getCustAcctId())
                .cust(cust)
                .acctName(customerAccountBillUpdateRequest.getAccountName())
                .acctNo(cust_acct.getAcctNo())
                .stId(StatusCode.CUST_ACC_DEL)
                .acctTpId(GeneralTypes.CUST_ACCT)
                .descr(customerAccountBillUpdateRequest.getAccountDescription())
                .build();

        this.iCustomerAccountRepository.save(custAcct);

        CustomerAccountBillResponse response = CustomerAccountBillResponse.builder()
                .accountDescription(custAcct.getDescr())
                .accountName(custAcct.getAcctName())
                .customerId(custAcct.getCustAcctId())
                .createAddressWithCustomerResponse(adressResponse.getData())
                .build();
        return  new SuccessDataResult<>(response,messageSourceService.getMessages(Messages.SuccessMessages.Updated));
    }


    private List<Cust_Acct> CheckCustomer(Long custId){

        List<Cust_Acct> cust_acct= this.iCustomerAccountRepository.custAcctCheck(custId);

        if (cust_acct==null){
            throw new BusinessException(messageSourceService.getMessages(Messages.ErrorMessages.NotFound));
        }
        return cust_acct;
    }

}
