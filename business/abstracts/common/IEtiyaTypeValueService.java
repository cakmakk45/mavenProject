package com.beymen.business.abstracts.common;

import com.beymen.entities.concretes.common.Etiya_Type_Value;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface IEtiyaTypeValueService {
    DataResult<List<Etiya_Type_Value>> getAll();
}
