package com.beymen.api.controllers.cam;

import com.beymen.business.abstracts.cam.ICustomerTypeService;
import com.beymen.business.constant.Paths;
import com.beymen.entities.concretes.cam.Cust_TP;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"customerTypes")
@AllArgsConstructor
public class CustomerTypeController {
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/getAll")
    public DataResult<List<Cust_TP>> getAll() {
        return this.iCustomerTypeService.getAll();
    }

}
