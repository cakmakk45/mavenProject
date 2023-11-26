package com.beymen.business.abstracts.order;

import com.beymen.entities.concretes.order.Cmpg_prod_Ofr;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface ICmpgProdOfrService {
    DataResult<List<Cmpg_prod_Ofr>>getAll();
}
