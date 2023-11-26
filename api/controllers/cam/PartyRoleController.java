package com.beymen.api.controllers.cam;

import com.beymen.business.abstracts.cam.IPartyRoleService;
import com.beymen.business.constant.Paths;
import com.beymen.entities.concretes.cam.Party_Role;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"partyRoles")
@AllArgsConstructor
public class PartyRoleController {
    private IPartyRoleService iPartyRoleService;

    @GetMapping("/getAll")
    public DataResult<List<Party_Role>> getAll() {
        return this.iPartyRoleService.getAll();
    }
}
