package com.beymen.api.controllers.product;

import com.beymen.business.abstracts.product.IProductSpecificationServiceSpecificationService;
import com.beymen.entities.concretes.prod.Prod_Spec_Srvc_Spec;
import com.beymen.business.constant.Paths;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"ProductSpecificationServiceSpecifications")
@AllArgsConstructor
public class ProductSpecificationServiceSpecificationController {
    private IProductSpecificationServiceSpecificationService productSpecificationServiceSpecificationService;

    @GetMapping("/getall")
    public DataResult<List<Prod_Spec_Srvc_Spec>> getAll(){
        return this.productSpecificationServiceSpecificationService.getAll();
    }
}
