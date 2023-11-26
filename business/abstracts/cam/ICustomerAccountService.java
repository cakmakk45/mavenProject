package com.beymen.business.abstracts.cam;

import com.beymen.business.dtos.requests.customer.CustomerAccountBillRequest;
import com.beymen.business.dtos.requests.customer.CustomerAccountBillUpdateRequest;
import com.beymen.entities.concretes.cam.Cust_Acct;
import com.beymen.business.dtos.responses.customer.CustomerAccountBillResponse;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface ICustomerAccountService {
    DataResult<List<Cust_Acct>> getAll();

    DataResult<CustomerAccountBillResponse> customerAccountBillCreated
            (CustomerAccountBillRequest customerAccountBillRequest);

    DataResult<CustomerAccountBillResponse> customerAccountBillUpdeted
            (CustomerAccountBillUpdateRequest customerAccountBillUpdateRequest);
}
