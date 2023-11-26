package com.beymen.api.controllers.cam;

import com.beymen.business.abstracts.cam.IIndividualService;
import com.beymen.business.constant.Paths;
import com.beymen.business.dtos.requests.individual.UpdateIndividualRequest;
import com.beymen.business.dtos.responses.individual.UpdateIndividualResponse;
import com.beymen.entities.concretes.cam.Ind;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"individuals")
@AllArgsConstructor
public class IndividualController {
    private IIndividualService iIndividualService;

    @GetMapping("/getAll")
    public DataResult<List<Ind>> getAll() {
        return this.iIndividualService.getAll();
    }

    @GetMapping("/getWithNatId")
    public Ind getByNatId(@RequestParam @Valid Long natId){
        return this.iIndividualService.findByNationalityId(natId);
    }

    @PutMapping("/updateInd")
    public DataResult<UpdateIndividualResponse> updateInd(@RequestBody @Valid UpdateIndividualRequest updateIndividualRequest){
        return this.iIndividualService.updateInd(updateIndividualRequest);
    }
}
