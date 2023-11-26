package com.beymen.business.abstracts.common;

import com.beymen.entities.concretes.common.Srvc_Spec;
import com.beymen.core.utilities.results.DataResult;

import java.util.List;

public interface ISrvcSpecService {
    DataResult<List<Srvc_Spec>> getAll();
}
