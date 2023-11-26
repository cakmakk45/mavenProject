package com.beymen.business.abstracts.cam;

import com.beymen.entities.concretes.cam.Party_Role_Tp;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface IPartyRoleTypeService {
    DataResult<List<Party_Role_Tp>> getAll();

    Party_Role_Tp findById(Long id);
}
