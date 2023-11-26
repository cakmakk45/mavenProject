package com.beymen.api.controllers.product;

import com.beymen.business.abstracts.product.IProductSpecificationCharacteristicUseService;
import com.beymen.entities.concretes.prod.Prod_Spec_Char_Use;
import com.beymen.business.constant.Paths;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"ProductSpecificationCharacteristicUses")
@AllArgsConstructor
public class ProductSpecificationCharacteristicUseController {
    private IProductSpecificationCharacteristicUseService productSpecificationCharacteristicUseService;

    @GetMapping("/getall")
    public DataResult<List<Prod_Spec_Char_Use>> getAll(){
        return  this.productSpecificationCharacteristicUseService.getAll();
    }
}
