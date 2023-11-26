package com.beymen.business.abstracts.product;

import com.beymen.core.utilities.results.DataResult;
import com.beymen.entities.concretes.prod.Prod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    DataResult<List<Prod>> getAll();

    DataResult<Page<List<Prod>>> findAllWithPagination(Pageable pageable);
}
