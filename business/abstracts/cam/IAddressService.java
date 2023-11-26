package com.beymen.business.abstracts.cam;

import com.beymen.business.dtos.requests.address.AddressDeletedRequest;
import com.beymen.business.dtos.requests.address.AddressUpdatedRequest;
import com.beymen.business.dtos.requests.address.CreateAddressWithCustomerRequest;
import com.beymen.entities.concretes.cam.Addr;
import com.beymen.business.dtos.responses.address.AddressUpdatedResponse;
import com.beymen.business.dtos.responses.address.CreateAddressWithCustomerResponse;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAddressService {

    DataResult<List<Addr>> getAll();

    DataResult<Page<List<Addr>>> findAllWithPagination(Pageable pageable);

    Result deleteAddress(AddressDeletedRequest addressDeletedRequest);

    DataResult<List<AddressUpdatedResponse>> updateAddress(AddressUpdatedRequest addressUpdatedRequest);

    DataResult<CreateAddressWithCustomerResponse> createAddressForCustomer
            (CreateAddressWithCustomerRequest createAddressWithCustomerRequest);


}
