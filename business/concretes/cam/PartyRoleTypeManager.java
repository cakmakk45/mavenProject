package com.beymen.business.concretes.cam;

import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.business.abstracts.cam.IPartyRoleTypeService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.cam.Party_Role_Tp;
import com.beymen.repository.abstracs.cam.IPartyRoleTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PartyRoleTypeManager implements IPartyRoleTypeService {
    private IPartyRoleTypeRepository iPartyRoleTypeRepository;

    private IMessageSourceService messageSourceService;

    @Override
    public DataResult<List<Party_Role_Tp>> getAll() {
        return new SuccessDataResult<>(this.iPartyRoleTypeRepository.findAll(),messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }

    @Override
    public Party_Role_Tp findById(Long id) {
        return this.iPartyRoleTypeRepository.findById(id).orElseThrow();
    }
}
