package com.beymen.business.abstracts.product;

import com.beymen.core.utilities.results.DataResult;
import com.beymen.entities.concretes.prod.Prod_Char_Val;

import java.util.List;

public interface IProductCharacteristicValueService {
    DataResult<List<Prod_Char_Val>> getAll();
}
