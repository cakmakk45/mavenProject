package com.beymen.business.abstracts.cam;

import com.beymen.business.dtos.requests.contactMedium.ContactMediumUpdatedRequest;
import com.beymen.entities.concretes.cam.CntcMedium;
import com.beymen.business.dtos.responses.contactMedium.ContactMediumUpdatedResponse;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface IContactMediumService {
    DataResult<List<CntcMedium>> getAll();

    DataResult<ContactMediumUpdatedResponse> contactMediumUpdateCustomer
            (ContactMediumUpdatedRequest contactMediumUpdatedRequest);
}
