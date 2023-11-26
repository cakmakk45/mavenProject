package com.beymen.business.concretes.common;

import com.beymen.business.abstracts.common.IGnlTpService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.common.Gnl_Tp;
import com.beymen.repository.abstracs.common.IGnlTpRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class GnlTpManager implements IGnlTpService {
    private IGnlTpRepository gnlTpRepository;

    private IMessageSourceService messageSourceService;

    @Override
    public DataResult<List<Gnl_Tp>> getAll() {
        List<Gnl_Tp>response=gnlTpRepository.findAll();
        return new SuccessDataResult<>(response, messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
