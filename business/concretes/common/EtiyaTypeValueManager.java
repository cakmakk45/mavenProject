package com.beymen.business.concretes.common;

import com.beymen.business.abstracts.common.IEtiyaTypeValueService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.common.Etiya_Type_Value;
import com.beymen.repository.abstracs.common.IEtiyaTypeValueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtiyaTypeValueManager implements IEtiyaTypeValueService {
    private IEtiyaTypeValueRepository etiyaTypeValueRepository;

    private IMessageSourceService messageSourceService;

    @Override
    public DataResult<List<Etiya_Type_Value>> getAll() {
        List<Etiya_Type_Value>response=etiyaTypeValueRepository.findAll();
        return new SuccessDataResult<>(response, messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
