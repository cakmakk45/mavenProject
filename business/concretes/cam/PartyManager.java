package com.beymen.business.concretes.cam;

import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.repository.abstracs.cam.IPartyRepository;
import com.beymen.business.abstracts.cam.IPartyService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.Enum.GeneralTypes;
import com.beymen.core.utilities.Enum.StatusCode;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.cam.Ind;
import com.beymen.entities.concretes.cam.Party;
import com.beymen.entities.concretes.cam.Party_Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PartyManager implements IPartyService {
    private IPartyRepository iPartyRepository;

    private IMessageSourceService messageSourceService;

    @Override
    public DataResult<List<Party>> getAll() {
        return new SuccessDataResult<List<Party>>(this.iPartyRepository.findAll(),messageSourceService.getMessages(Messages.SuccessMessages.Listall));

    }

    @Override
    public Party createParty(Ind ind, Party_Role party_role) {

        return Party.builder()
                .ind(ind)
                .partyRoles(List.of(party_role))
                .partyTpId(GeneralTypes.INDV)
                .stId(StatusCode.PARTY_ACTV)
                .build();
    }

    @Override
    public Party addParty(Party party) {
        return this.iPartyRepository.save(party);
    }

}
