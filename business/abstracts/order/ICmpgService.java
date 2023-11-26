package com.beymen.business.abstracts.order;

import com.beymen.entities.concretes.order.Cmpg;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface ICmpgService {
    DataResult<List<Cmpg>> getAll();
}
