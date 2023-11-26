package com.beymen.business.concretes.order;

import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.repository.abstracs.order.IBusinessInteractionTypeRepository;
import com.beymen.business.abstracts.order.IBsnInterTpService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.order.Bsn_Inter_Tp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BsnInterTpManager implements IBsnInterTpService {
    private IBusinessInteractionTypeRepository businessInteractionTypeRepository;

    private IMessageSourceService messageSourceService;
    @Override
    public DataResult<List<Bsn_Inter_Tp>> getAll() {
        return new SuccessDataResult<>(this.businessInteractionTypeRepository.findAll(),messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
