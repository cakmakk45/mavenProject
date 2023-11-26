package com.beymen.business.abstracts.cam;

import com.beymen.entities.concretes.cam.Ind;
import com.beymen.entities.concretes.cam.Party;
import com.beymen.entities.concretes.cam.Party_Role;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface IPartyService {
    DataResult<List<Party>> getAll();

    Party createParty(Ind ind, Party_Role party_role);

    Party addParty(Party party);

}
