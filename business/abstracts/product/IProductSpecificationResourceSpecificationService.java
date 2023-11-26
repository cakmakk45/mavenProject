package com.beymen.business.abstracts.product;

import com.beymen.core.utilities.results.DataResult;
import com.beymen.entities.concretes.prod.Prod_Spec_Rsrc_Spec;

import java.util.List;

public interface IProductSpecificationResourceSpecificationService {

   DataResult<List<Prod_Spec_Rsrc_Spec> > getAll();
}
