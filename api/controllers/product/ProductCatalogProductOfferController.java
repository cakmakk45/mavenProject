package com.beymen.api.controllers.product;

import com.beymen.business.abstracts.product.IProductCatalogProductOfferService;
import com.beymen.entities.concretes.prod.Prod_Catal_Prod_Ofr;
import com.beymen.business.constant.Paths;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"productcatalogproductoffers")
@AllArgsConstructor
public class ProductCatalogProductOfferController {
    private IProductCatalogProductOfferService productCatalogProductOfferService;

    @GetMapping("/getall")
    public DataResult<List<Prod_Catal_Prod_Ofr>> getAll(){
        return this.productCatalogProductOfferService.getAll();
    }

}
