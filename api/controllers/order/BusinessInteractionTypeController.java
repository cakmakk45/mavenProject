package com.beymen.api.controllers.order;

import com.beymen.business.abstracts.order.IBsnInterTpService;
import com.beymen.business.constant.Paths;
import com.beymen.entities.concretes.order.Bsn_Inter_Tp;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"BusinessInteractionTypes")
@AllArgsConstructor
public class BusinessInteractionTypeController {
    private IBsnInterTpService bsnInterTpService;

    @GetMapping("/getall")
    public DataResult<List<Bsn_Inter_Tp>> getAll(){
        return this.bsnInterTpService.getAll();
    }
}
