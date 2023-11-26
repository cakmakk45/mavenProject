package com.beymen.api.controllers.common;

import com.beymen.business.abstracts.common.IGnlStService;
import com.beymen.entities.concretes.common.Gnl_St;

import com.beymen.business.constant.Paths;
import com.beymen.core.utilities.results.DataResult;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(Paths.apiPrefix+"GnlSt")
public class GnlStController {

    IGnlStService gnlStService;

    @GetMapping("/getAll")
    public DataResult<List<Gnl_St>> getAll() {
        return gnlStService.getAll();
    }
}
