package com.beymen.api.controllers.order;

import com.beymen.business.abstracts.order.IBsnInterService;
import com.beymen.business.constant.Paths;
import com.beymen.entities.concretes.order.Bsn_Inter;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"BusinessInteractions")
@AllArgsConstructor
public class BusinessInteractionController {
    private IBsnInterService bsnInterService;

    @GetMapping("/getall")
    public DataResult<List<Bsn_Inter>> getAll(){
        return this.bsnInterService.getAll();
    }
}
