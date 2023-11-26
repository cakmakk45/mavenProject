package com.beymen.business.concretes.order;

import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.repository.abstracs.order.IBusinessInteractionSpecificationRepository;
import com.beymen.business.abstracts.order.IBsnInterSpecService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.order.Bsn_Inter_Spec;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class BsnInterSpecManager implements IBsnInterSpecService {
    private IBusinessInteractionSpecificationRepository businessInteractionSpecificationRepository;

    private IMessageSourceService messageSourceService;

    @Override
    public DataResult<List<Bsn_Inter_Spec>> getAll() {
        return new SuccessDataResult<>(businessInteractionSpecificationRepository.findAll(), messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
