package com.beymen.api.controllers.order;

import com.beymen.business.abstracts.order.IBsnInterStService;
import com.beymen.business.constant.Paths;
import com.beymen.entities.concretes.order.Bsn_Inter_St;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"BusinessInteractionSts")
@AllArgsConstructor
public class BusinessInteractionStController {
    private IBsnInterStService bsnInterStService;

    @GetMapping("/getall")
    DataResult<List<Bsn_Inter_St>> getAll(){
        return this.bsnInterStService.getAll();
    }

}
