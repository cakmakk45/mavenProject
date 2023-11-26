package com.beymen.business.concretes.order;

import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.repository.abstracs.order.ICmpgRepository;
import com.beymen.business.abstracts.order.ICmpgService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.order.Cmpg;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CmpgManager implements ICmpgService {
    private ICmpgRepository cmpgRepository;

    private IMessageSourceService messageSourceService;


    @Override
    public DataResult<List<Cmpg>> getAll() {
        return new SuccessDataResult<>( this.cmpgRepository.findAll(), messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
