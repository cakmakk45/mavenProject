package com.beymen.api.controllers.product;

import com.beymen.business.abstracts.product.IProductRelationService;
import com.beymen.entities.concretes.prod.Prod_Rel;
import com.beymen.business.constant.Paths;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(Paths.apiPrefix+"productrelations")
@AllArgsConstructor
public class ProductRelationController {
    private IProductRelationService productRelationService;

    @GetMapping("/getall")
    public DataResult<List<Prod_Rel>> getAll(){
        return this.productRelationService.getAll();
    }

}
