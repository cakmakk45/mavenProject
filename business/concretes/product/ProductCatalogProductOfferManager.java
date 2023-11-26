package com.beymen.business.concretes.product;

import com.beymen.business.abstracts.product.IProductCatalogProductOfferService;
import com.beymen.business.constant.Messages;
import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.entities.concretes.prod.Prod_Catal_Prod_Ofr;
import com.beymen.repository.abstracs.prod.IProductCatalogProductOfferRepository;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductCatalogProductOfferManager implements IProductCatalogProductOfferService {
        private IProductCatalogProductOfferRepository productCatalogProductOfferRepository;

        private IMessageSourceService messageSourceService;

        @Override
        public DataResult<List<Prod_Catal_Prod_Ofr>> getAll() {
        return new SuccessDataResult<>(this.productCatalogProductOfferRepository.findAll(), messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }
}
