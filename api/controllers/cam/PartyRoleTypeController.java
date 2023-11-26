package com.beymen.api.controllers.cam;

import com.beymen.business.abstracts.cam.IPartyRoleTypeService;
import com.beymen.business.constant.Paths;
import com.beymen.entities.concretes.cam.Party_Role_Tp;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"partyRoleTypes")
@AllArgsConstructor
public class PartyRoleTypeController {
    private IPartyRoleTypeService iPartyRoleTypeService;

    @GetMapping("/getAll")
    public DataResult<List<Party_Role_Tp>> getAll() {
        return this.iPartyRoleTypeService.getAll();
    }
}
