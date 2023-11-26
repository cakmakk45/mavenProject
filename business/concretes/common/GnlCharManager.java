package com.beymen.business.concretes.common;

import com.beymen.business.abstracts.common.IGnlCharService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.common.Gnl_Char;
import com.beymen.repository.abstracs.common.IGnlCharRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GnlCharManager implements IGnlCharService {
    private IGnlCharRepository gnlCharRepository;

    private IMessageSourceService messageSourceService;

    @Override
    public DataResult<List<Gnl_Char>> getAll() {
        List<Gnl_Char>response=gnlCharRepository.findAll();
        return new SuccessDataResult<>(response, messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
