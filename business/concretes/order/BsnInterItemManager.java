package com.beymen.business.concretes.order;

import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.repository.abstracs.order.IBusinessInteractionItemRepository;
import com.beymen.business.abstracts.order.IBsnInterItemService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.order.Bsn_Inter_Item;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class BsnInterItemManager implements IBsnInterItemService {
    private IBusinessInteractionItemRepository businessInteractionItemRepository;

    private IMessageSourceService messageSourceService;

    @Override
    public DataResult<List<Bsn_Inter_Item>> getAll() {
        return new SuccessDataResult<>(businessInteractionItemRepository.findAll(), messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
