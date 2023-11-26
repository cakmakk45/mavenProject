package com.beymen.business.concretes.cam;

import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.business.abstracts.cam.ICustomerTypeService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.expection.business.BusinessException;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.cam.Cust_TP;
import com.beymen.repository.abstracs.cam.ICustomerTypeRepsitory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CustomerTypeManager implements ICustomerTypeService {
    private ICustomerTypeRepsitory iCustomerTypeRepsitory;

    private IMessageSourceService messageSourceService;
    @Override
    public DataResult<List<Cust_TP>> getAll() {
        return new SuccessDataResult<>(this.iCustomerTypeRepsitory.findAll(),messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }

    @Override
    public Cust_TP findById(Long id) {
        return this.iCustomerTypeRepsitory.findById(id).orElseThrow(
                ()-> new BusinessException(messageSourceService.getMessages(Messages.ErrorMessages.NotFound)));


}}

