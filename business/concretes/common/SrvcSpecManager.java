package com.beymen.business.concretes.common;

import com.beymen.business.abstracts.common.ISrvcSpecService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.common.Srvc_Spec;
import com.beymen.repository.abstracs.common.ISrvcSpecRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SrvcSpecManager implements ISrvcSpecService {
   private ISrvcSpecRepository srvcSpecRepository;

   private IMessageSourceService messageSourceService;

    @Override
    public DataResult<List<Srvc_Spec>> getAll() {
        List<Srvc_Spec> reponse= srvcSpecRepository.findAll();
        return new SuccessDataResult<>(reponse, messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
