package com.beymen.business.abstracts.cam;

import com.beymen.entities.concretes.cam.Cust_acct_Prod_Invl;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface ICustomerAccountProductInvolveService {
    DataResult<List<Cust_acct_Prod_Invl>> getAll();

}
