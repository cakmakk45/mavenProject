package com.beymen.business.concretes.order;

import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.repository.abstracs.order.ICmpgProdOfrRepository;
import com.beymen.business.abstracts.order.ICmpgProdOfrService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.order.Cmpg_prod_Ofr;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class CmpgProdOfrManager implements ICmpgProdOfrService {
    private ICmpgProdOfrRepository cmpgProdOfrRepository;

    private IMessageSourceService messageSourceService;

    @Override
    public DataResult<List<Cmpg_prod_Ofr>> getAll() {
        return new SuccessDataResult<List<Cmpg_prod_Ofr>>(this.cmpgProdOfrRepository.findAll(),messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
