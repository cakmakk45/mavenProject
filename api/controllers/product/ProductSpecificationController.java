package com.beymen.api.controllers.product;

import com.beymen.business.abstracts.product.IProductSpecificationService;
import com.beymen.entities.concretes.prod.Prod_Spec;
import com.beymen.business.constant.Paths;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"ProductSpecifications")
@AllArgsConstructor
public class ProductSpecificationController {
    private IProductSpecificationService productSpecificationService;

    public DataResult<List<Prod_Spec>> getAll(){
        return this.productSpecificationService.getAll();
    }
}
