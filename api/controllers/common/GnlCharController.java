package com.beymen.api.controllers.common;

import com.beymen.business.abstracts.common.IGnlCharService;
import com.beymen.entities.concretes.common.Gnl_Char;
import com.beymen.business.constant.Paths;
import com.beymen.core.utilities.results.DataResult;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(Paths.apiPrefix+"GnlChar")
public class GnlCharController {

    IGnlCharService gnlCharService;

    @GetMapping("/getAll")
    public DataResult<List<Gnl_Char>> getAll(){
        return gnlCharService.getAll();}
}
