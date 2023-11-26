package com.beymen.api.controllers.cam;

import com.beymen.business.abstracts.cam.ICustomerService;
import com.beymen.business.constant.Paths;
import com.beymen.business.dtos.requests.customer.CreateCustomerRequest;
import com.beymen.business.dtos.requests.customer.FilteredCustomerRequest;
import com.beymen.entities.concretes.cam.Cust;
import com.beymen.business.dtos.responses.customer.CreateCustomerResponse;
import com.beymen.business.dtos.responses.customer.DeleteCustomerResponse;
import com.beymen.business.dtos.responses.customer.FilterCustomerResponse;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"customers")
@AllArgsConstructor
public class CustomerController {
    private ICustomerService iCustomerService;

    @GetMapping("/getAll")
    public DataResult<List<Cust>> getAll() {
        return this.iCustomerService.getAll();
    }

    @GetMapping("/getAllWithPagination")
    public DataResult<Page<List<Cust>>> getAllWithPagination(@RequestParam("page") @Max(50) int page, @RequestParam("pageSize") @Max(50) int pageSize) {
        Pageable pageable= PageRequest.of(page-1,pageSize);
        return this.iCustomerService.findAllWithPagination(pageable);
    }

    @PostMapping("/filterCustomer")
    public DataResult<List<FilterCustomerResponse>> filteredCustomer (@RequestBody @Valid FilteredCustomerRequest filteredCustomerRequest){
        return this.iCustomerService.filteredCustomer(filteredCustomerRequest);
    }

    @DeleteMapping("/deleteCustomer")
    public DataResult<List<DeleteCustomerResponse>> deleteCustomer(@RequestParam @Valid Long customerId){
        return this.iCustomerService.deleteCustomer(customerId);
    }

    @PostMapping("/createCustomer")
    public DataResult<CreateCustomerResponse> createCustomer(@RequestBody @Valid CreateCustomerRequest createCustomerRequest){
        return this.iCustomerService.createCustomer(createCustomerRequest);
    }
}
