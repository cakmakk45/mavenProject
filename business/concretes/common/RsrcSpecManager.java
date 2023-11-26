package com.beymen.business.concretes.common;

import com.beymen.business.abstracts.common.IRsrcSpecService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.common.Rsrc_Spec;
import com.beymen.repository.abstracs.common.IRsrcSpecRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class RsrcSpecManager implements IRsrcSpecService {
   private IRsrcSpecRepository rsrcSpecRepository;


    private IMessageSourceService messageSourceService;
    @Override
    public DataResult<List<Rsrc_Spec>> getAll() {
        List<Rsrc_Spec>response=rsrcSpecRepository.findAll();
        return new SuccessDataResult<>(response,messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
