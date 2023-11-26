package com.beymen.api.controllers.product;

import com.beymen.business.abstracts.product.IProductCharacteristicValueService;
import com.beymen.entities.concretes.prod.Prod_Char_Val;
import com.beymen.business.constant.Paths;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"productcharacteristicvalues")
@AllArgsConstructor
public class ProductCharacteristicValueController {

    private IProductCharacteristicValueService productCharacteristicValueService;

    @GetMapping("/getall")
    public DataResult<List<Prod_Char_Val>> getAll(){
        return this.productCharacteristicValueService.getAll();
    }

}
