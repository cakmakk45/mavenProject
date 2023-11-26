package com.beymen.business.abstracts.order;

import com.beymen.entities.concretes.order.Bsn_Inter_St;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface IBsnInterStService {
   DataResult<List<Bsn_Inter_St>>  getAll();
}
