package com.beymen.api.controllers.common;

import com.beymen.business.abstracts.common.IRsrcSpecService;
import com.beymen.entities.concretes.common.Rsrc_Spec;
import com.beymen.business.constant.Paths;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(Paths.apiPrefix+"RsrcSpec")
public class RsrcSpecController {
    IRsrcSpecService rsrcSpecService;

    @GetMapping("/getAll")
    public DataResult<List<Rsrc_Spec>> getAll() {
        return rsrcSpecService.getAll();
    }
}
