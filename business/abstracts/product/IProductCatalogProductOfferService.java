package com.beymen.business.abstracts.product;

import com.beymen.core.utilities.results.DataResult;
import com.beymen.entities.concretes.prod.Prod_Catal_Prod_Ofr;

import java.util.List;

public interface IProductCatalogProductOfferService {
    DataResult<List<Prod_Catal_Prod_Ofr>> getAll();
}
