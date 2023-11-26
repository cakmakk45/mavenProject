package com.beymen.business.abstracts.product;

import com.beymen.core.utilities.results.DataResult;
import com.beymen.entities.concretes.prod.Prod_Spec;

import java.util.List;

public interface IProductSpecificationService {
    DataResult<List<Prod_Spec>> getAll();
}
