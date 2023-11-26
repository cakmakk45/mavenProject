package com.beymen.business.concretes.product;

import com.beymen.business.abstracts.product.IProductCatalogService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.entities.concretes.prod.Prod_Catal;
import com.beymen.repository.abstracs.prod.IProductCatalogRepository;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductCatalogManager implements IProductCatalogService {

    private IProductCatalogRepository productCatalogRepository;

    private IMessageSourceService messageSourceService;
    @Override
    public DataResult<List<Prod_Catal>> getAll() {
        return new SuccessDataResult<>(this.productCatalogRepository.findAll(), messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
