package com.beymen.business.abstracts.product;

import com.beymen.core.utilities.results.DataResult;
import com.beymen.entities.concretes.prod.Prod_Spec_Char_Use;

import java.util.List;

public interface IProductSpecificationCharacteristicUseService {

    DataResult<List<Prod_Spec_Char_Use>> getAll();
}
