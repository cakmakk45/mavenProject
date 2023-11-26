package com.beymen.business.abstracts.product;

import com.beymen.core.utilities.results.DataResult;
import com.beymen.entities.concretes.prod.Prod_Rel;

import java.util.List;

public interface IProductRelationService {
    DataResult<List<Prod_Rel>> getAll();
}
