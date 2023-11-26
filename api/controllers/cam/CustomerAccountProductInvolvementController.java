package com.beymen.api.controllers.cam;

import com.beymen.business.abstracts.cam.ICustomerAccountProductInvolveService;
import com.beymen.business.constant.Paths;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.apiPrefix+"customerAccountProductInvolves")
@AllArgsConstructor
public class CustomerAccountProductInvolvementController {
    private ICustomerAccountProductInvolveService iCustomerAccountProductInvolveService;
}
