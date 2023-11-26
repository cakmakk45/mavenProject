package com.beymen.business.abstracts.cam;

import com.beymen.entities.concretes.cam.Cust_TP;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface ICustomerTypeService {
    DataResult<List<Cust_TP>> getAll();

    Cust_TP findById(Long id);
}
