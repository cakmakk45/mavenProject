package com.beymen.api.controllers.common;


import com.beymen.business.abstracts.common.ISrvcSpecService;
import com.beymen.entities.concretes.common.Srvc_Spec;
import com.beymen.business.constant.Paths;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(Paths.apiPrefix+"SrvcSpec")
public class SrvcSpecController {

    ISrvcSpecService srvcSpecService;

    @GetMapping("/getAll")
    public DataResult<List<Srvc_Spec>> getAll() {
        return srvcSpecService.getAll();
    }
}
