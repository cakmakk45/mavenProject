package com.beymen.business.concretes.common;

import com.beymen.business.abstracts.common.IGnlStService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.common.Gnl_St;
import com.beymen.repository.abstracs.common.IGnlStRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class GnlStManager implements IGnlStService {
    private IGnlStRepository gnlStRepository;

    private IMessageSourceService messageSourceService;

    @Override
    public DataResult<List<Gnl_St>> getAll() {
       List<Gnl_St>response=gnlStRepository.findAll();
       return new SuccessDataResult<>(response,messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
