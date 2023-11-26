package com.beymen.business.abstracts.cam;

import com.beymen.business.dtos.requests.customer.CreateCustomerRequest;
import com.beymen.business.dtos.requests.individual.UpdateIndividualRequest;
import com.beymen.entities.concretes.cam.Ind;
import com.beymen.business.dtos.responses.individual.UpdateIndividualResponse;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface IIndividualService {
    DataResult<List<Ind>> getAll();
    Ind findByNationalityId(Long nationalityId);

    DataResult<UpdateIndividualResponse> updateInd(UpdateIndividualRequest updateIndividualRequest);

     Ind createIndividual (CreateCustomerRequest createCustomerRequest);

     Ind addInd(Ind ind);

}
