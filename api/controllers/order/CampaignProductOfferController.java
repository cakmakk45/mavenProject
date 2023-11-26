package com.beymen.api.controllers.order;

import com.beymen.business.abstracts.order.ICmpgProdOfrService;
import com.beymen.business.constant.Paths;
import com.beymen.entities.concretes.order.Cmpg_prod_Ofr;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(Paths.apiPrefix+"CampaignProductOffers")
@AllArgsConstructor
public class CampaignProductOfferController {
    private ICmpgProdOfrService cmpgProdOfrService;

    @GetMapping("/getall")
    public DataResult<List<Cmpg_prod_Ofr>> getAll(){
        return this.cmpgProdOfrService.getAll();
    }
}
