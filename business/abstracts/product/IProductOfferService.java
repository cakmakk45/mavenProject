package com.beymen.business.abstracts.product;

import com.beymen.core.utilities.results.DataResult;
import com.beymen.entities.concretes.prod.Prod_Ofr;

import java.util.List;

public interface IProductOfferService {
    DataResult<List<Prod_Ofr>> getAll();
}
