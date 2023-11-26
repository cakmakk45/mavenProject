package com.beymen.business.abstracts.common;

import com.beymen.entities.concretes.common.Rsrc_Spec;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface IRsrcSpecService {

    DataResult<List<Rsrc_Spec>> getAll();
}
