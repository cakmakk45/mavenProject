package com.beymen.business.abstracts.common;

import com.beymen.entities.concretes.common.Gnl_Tp;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface IGnlTpService {
    DataResult<List<Gnl_Tp>> getAll();
}
