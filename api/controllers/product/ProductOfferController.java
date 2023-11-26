package com.beymen.api.controllers.product;

import com.beymen.business.abstracts.product.IProductOfferService;
import com.beymen.entities.concretes.prod.Prod_Ofr;
import com.beymen.business.constant.Paths;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(Paths.apiPrefix+"productoffers")
@AllArgsConstructor
public class ProductOfferController {
    private IProductOfferService productOfferService;

    @GetMapping("/getall")
    public DataResult<List<Prod_Ofr>> getAll(){
        return this.productOfferService.getAll();
    }
}
