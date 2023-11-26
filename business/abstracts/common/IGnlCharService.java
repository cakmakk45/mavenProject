package com.beymen.business.abstracts.common;

import com.beymen.entities.concretes.common.Gnl_Char;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface IGnlCharService {
   DataResult<List<Gnl_Char>> getAll();
}
