package com.beymen.api.controllers.common;


import com.beymen.business.abstracts.common.IEtiyaTypeValueService;
import com.beymen.entities.concretes.common.Etiya_Type_Value;
import com.beymen.business.constant.Paths;
import com.beymen.core.utilities.results.DataResult;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(Paths.apiPrefix+"TypeValue")
public class TypeValueController {

    TypeValueService TypeValueService;

     @GetMapping("/getAll")
    public DataResult<List<Type_Value>> getAll(){
        return TypeValueService.getAll();}
}
