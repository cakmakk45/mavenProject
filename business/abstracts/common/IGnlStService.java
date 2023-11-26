package com.beymen.business.abstracts.common;

import com.beymen.entities.concretes.common.Gnl_St;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface IGnlStService {
    DataResult<List<Gnl_St>> getAll();
}
