package com.beymen.api.controllers.order;

import com.beymen.business.abstracts.order.IBsnInterSpecService;
import com.beymen.business.constant.Paths;
import com.beymen.entities.concretes.order.Bsn_Inter_Spec;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"BusinessInteractionSpecifications")
@AllArgsConstructor
public class BusinessInteractionSpecificationController {
    private IBsnInterSpecService bsnInterSpecService;


    @GetMapping("/getall")
    public DataResult<List<Bsn_Inter_Spec>> getAll(){
        return this.bsnInterSpecService.getAll();
    }
}
