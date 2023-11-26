package com.beymen.api.controllers.order;

import com.beymen.business.abstracts.order.ICmpgService;
import com.beymen.business.constant.Paths;
import com.beymen.entities.concretes.order.Cmpg;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"Campaigns")
@AllArgsConstructor
public class CampaignController {
    private ICmpgService cmpgService;

    @GetMapping("/getall")
    public DataResult<List<Cmpg>> getAll(){
        return this.cmpgService.getAll();
    }
}
