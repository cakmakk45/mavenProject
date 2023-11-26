package com.beymen.business.abstracts.order;

import com.beymen.entities.concretes.order.Bsn_Inter;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface IBsnInterService {
    DataResult<List<Bsn_Inter>> getAll();
}
