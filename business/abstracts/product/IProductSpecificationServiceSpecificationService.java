package com.beymen.business.abstracts.product;

import com.beymen.core.utilities.results.DataResult;
import com.beymen.entities.concretes.prod.Prod_Spec_Srvc_Spec;

import java.util.List;

public interface IProductSpecificationServiceSpecificationService {
    DataResult<List<Prod_Spec_Srvc_Spec>> getAll();
}
