package com.beymen.business.abstracts.common;

import com.beymen.entities.concretes.common.Gnl_Char_Val;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface IGnlCharValueService {
    DataResult<List<Gnl_Char_Val>> getAll();
}
