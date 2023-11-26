package com.beymen.api.controllers.cam;

import com.beymen.business.abstracts.cam.IContactMediumService;
import com.beymen.business.constant.Paths;
import com.beymen.business.dtos.requests.contactMedium.ContactMediumUpdatedRequest;
import com.beymen.business.dtos.responses.contactMedium.ContactMediumUpdatedResponse;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix+"contactMediums")
@AllArgsConstructor
public class ContactMediumController {
    private IContactMediumService iContactMediumService;
    @PutMapping("/updateContactMedium")
    public DataResult<ContactMediumUpdatedResponse> updateContactMedium(@RequestBody @Valid ContactMediumUpdatedRequest contactMediumUpdatedRequest){
        return this.iContactMediumService.contactMediumUpdateCustomer(contactMediumUpdatedRequest);
    }
}
