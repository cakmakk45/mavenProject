package com.beymen.business.concretes.cam;

import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.business.abstracts.cam.IPartyRoleService;
import com.beymen.business.abstracts.cam.IPartyRoleTypeService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.Enum.PartyRoleTypes;
import com.beymen.core.utilities.Enum.StatusCode;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.cam.Cust;
import com.beymen.entities.concretes.cam.Party_Role;
import com.beymen.repository.abstracs.cam.IPartyRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PartyRoleManager implements IPartyRoleService {
    private IPartyRoleRepository iPartyRoleRepository;

    private IPartyRoleTypeService partyRoleTypeService;

    private IMessageSourceService messageSourceService;

    @Override
    public DataResult<List<Party_Role>> getAll() {
        return new SuccessDataResult<>(this.iPartyRoleRepository.findAll(),messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }

    @Override
    public Party_Role createPartyRole(Cust cust) {
        Party_Role createPartyRole=Party_Role.builder()
                .custs(cust)
                .stId(StatusCode.PARTY_ROLE_ACTV)
                .partyRoleTp(partyRoleTypeService.findById(PartyRoleTypes.CUST2))
                .build();
        return createPartyRole;
    }

    @Override
    public Party_Role addPartyRole(Party_Role party_role) {
        return this.iPartyRoleRepository.save(party_role);
    }
}
