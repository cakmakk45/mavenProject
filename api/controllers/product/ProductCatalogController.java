package com.beymen.api.controllers.product;

import com.beymen.business.abstracts.product.IProductCatalogService;
import com.beymen.entities.concretes.prod.Prod_Catal;
import com.beymen.business.constant.Paths;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"productcatalogs")
@AllArgsConstructor
public class ProductCatalogController {

    private IProductCatalogService productCatalogService;

    @GetMapping("/getall")
    public DataResult<List<Prod_Catal>> getAll(){
        return this.productCatalogService.getAll();
    }
}
