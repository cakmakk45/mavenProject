package com.beymen.business.abstracts.cam;

import com.beymen.business.dtos.requests.customer.CreateCustomerRequest;
import com.beymen.business.dtos.requests.customer.FilteredCustomerRequest;
import com.beymen.entities.concretes.cam.Cust;
import com.beymen.business.dtos.responses.customer.CreateCustomerResponse;
import com.beymen.business.dtos.responses.customer.DeleteCustomerResponse;
import com.beymen.business.dtos.responses.customer.FilterCustomerResponse;
import com.beymen.core.utilities.results.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    DataResult<List<Cust>> getAll();
    DataResult<List<FilterCustomerResponse>> filteredCustomer(FilteredCustomerRequest filteredCustomerRequest);
    DataResult<List<DeleteCustomerResponse>> deleteCustomer(Long customerId);

    DataResult<Page<List<Cust>>> findAllWithPagination(Pageable pageable);

    DataResult<CreateCustomerResponse>createCustomer(CreateCustomerRequest createCustomerRequest);
}
