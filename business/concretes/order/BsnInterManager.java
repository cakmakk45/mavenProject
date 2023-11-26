package com.beymen.business.concretes.order;

import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.business.abstracts.order.IBsnInterService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.order.Bsn_Inter;
import com.beymen.repository.abstracs.order.IBusinessInteractionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class BsnInterManager implements IBsnInterService {

    private IBusinessInteractionRepository businessInteractionRepository;

    private IMessageSourceService messageSourceService;

    @Override
    public DataResult<List<Bsn_Inter>> getAll() {
        return new SuccessDataResult<>(businessInteractionRepository.findAll(),messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
