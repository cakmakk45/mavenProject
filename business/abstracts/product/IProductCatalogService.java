package com.beymen.business.abstracts.product;

import com.beymen.core.utilities.results.DataResult;
import com.beymen.entities.concretes.prod.Prod_Catal;

import java.util.List;

public interface IProductCatalogService {
   DataResult<List<Prod_Catal>> getAll();
}
