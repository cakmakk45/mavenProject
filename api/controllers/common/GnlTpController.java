package com.beymen.api.controllers.common;

import com.beymen.business.abstracts.common.IGnlTpService;
import com.beymen.entities.concretes.common.Gnl_Tp;
import com.beymen.business.constant.Paths;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(Paths.apiPrefix+"GnlTp")
public class GnlTpController {

    IGnlTpService gnlTpService;

    @GetMapping("/getAll")
    public DataResult<List<Gnl_Tp>> getAll() {
        return gnlTpService.getAll();
    }
}
