package com.beymen.business.abstracts.cam;

import com.beymen.entities.concretes.cam.Cust;
import com.beymen.entities.concretes.cam.Party_Role;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface IPartyRoleService {
    DataResult<List<Party_Role>> getAll();

    Party_Role createPartyRole(Cust cust);

    Party_Role addPartyRole(Party_Role party_role);

}
