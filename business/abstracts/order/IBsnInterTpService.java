package com.beymen.business.abstracts.order;

import com.beymen.entities.concretes.order.Bsn_Inter_Tp;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface IBsnInterTpService {
    DataResult<List<Bsn_Inter_Tp>> getAll();
}
