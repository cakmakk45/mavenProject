package com.beymen.business.concretes.order;

import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.business.abstracts.order.IBsnInterStService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.order.Bsn_Inter_St;
import com.beymen.repository.abstracs.order.IBusinessInterStRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class BsnInterStManager implements IBsnInterStService {
   private IBusinessInterStRepository businessInterStRepository;

   private IMessageSourceService messageSourceService;

    @Override
    public DataResult<List<Bsn_Inter_St>> getAll() {

        return new SuccessDataResult<>(businessInterStRepository.findAll(),messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
