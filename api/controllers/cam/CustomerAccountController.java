package com.beymen.api.controllers.cam;

import com.beymen.business.abstracts.cam.ICustomerAccountService;
import com.beymen.business.constant.Paths;
import com.beymen.business.dtos.requests.customer.CustomerAccountBillRequest;
import com.beymen.business.dtos.requests.customer.CustomerAccountBillUpdateRequest;
import com.beymen.business.dtos.responses.customer.CustomerAccountBillResponse;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix+"customerAccounts")
@AllArgsConstructor
public class CustomerAccountController {
    private ICustomerAccountService iCustomerAccountService;
    @PostMapping("/createCustAccountBill")
    public DataResult<CustomerAccountBillResponse> createCustAccountBill(@RequestBody @Valid CustomerAccountBillRequest customerAccountBillRequest){
        return  this.iCustomerAccountService.customerAccountBillCreated(customerAccountBillRequest);
    }
    @PutMapping("/upduateBill")
    public DataResult<CustomerAccountBillResponse> updateCustAccountBill(@RequestBody @Valid CustomerAccountBillUpdateRequest customerAccountBillUpdateRequest){
        return this.iCustomerAccountService.customerAccountBillUpdeted(customerAccountBillUpdateRequest);
    }
}
