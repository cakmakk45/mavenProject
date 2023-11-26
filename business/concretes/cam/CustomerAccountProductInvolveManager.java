package com.beymen.business.concretes.cam;

import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.repository.abstracs.cam.ICustomerAccountProductInvolveRepository;
import com.beymen.business.abstracts.cam.ICustomerAccountProductInvolveService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.cam.Cust_acct_Prod_Invl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CustomerAccountProductInvolveManager implements ICustomerAccountProductInvolveService {
    private ICustomerAccountProductInvolveRepository iCustomerAccountProductInvolveRepository;

    private IMessageSourceService messageSourceService;
    @Override
    public DataResult<List<Cust_acct_Prod_Invl>> getAll() {
        return new SuccessDataResult<>(this.iCustomerAccountProductInvolveRepository.findAll(),messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
