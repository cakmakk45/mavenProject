package com.beymen.business.abstracts.order;

import com.beymen.entities.concretes.order.Bsn_Inter_Spec;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface IBsnInterSpecService {
    DataResult<List<Bsn_Inter_Spec>> getAll();
}
