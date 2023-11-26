package com.beymen.api.controllers.cam;

import com.beymen.business.abstracts.cam.IPartyService;
import com.beymen.business.constant.Paths;
import com.beymen.entities.concretes.cam.Party;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"parties")
@AllArgsConstructor
public class PartyController {
    private IPartyService iPartyService;

    @GetMapping("/getAll")
    public DataResult<List<Party>> getAll() {
        return this.iPartyService.getAll();
    }
}
