package com.beymen.business.concretes.common;

import com.beymen.business.abstracts.common.IGnlCharValueService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.common.Gnl_Char_Val;
import com.beymen.repository.abstracs.common.IGnlCharValueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class GnlCharValueManager implements IGnlCharValueService {
   private IGnlCharValueRepository gnlCharValueRepository;

   private IMessageSourceService messageSourceService;

    @Override
    public DataResult<List<Gnl_Char_Val>> getAll() {
        List<Gnl_Char_Val>response=gnlCharValueRepository.findAll();
        return new SuccessDataResult<>(response, messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
