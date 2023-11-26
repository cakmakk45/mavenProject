package com.beymen.api.controllers.cam;

import com.beymen.business.abstracts.cam.IAddressService;
import com.beymen.business.constant.Paths;
import com.beymen.business.dtos.requests.address.AddressDeletedRequest;
import com.beymen.business.dtos.requests.address.AddressUpdatedRequest;
import com.beymen.business.dtos.requests.address.CreateAddressWithCustomerRequest;
import com.beymen.entities.concretes.cam.Addr;
import com.beymen.business.dtos.responses.address.AddressUpdatedResponse;
import com.beymen.business.dtos.responses.address.CreateAddressWithCustomerResponse;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"addresses")
@AllArgsConstructor
public class AddressControler {
    private IAddressService addressService;

    @GetMapping("/getAll")
    public DataResult<List<Addr>> getAll() {
        return this.addressService.getAll();
    }


    @GetMapping("/getAllWithPagination")
    public DataResult<Page<List<Addr>>> getAllWithPagination(@RequestParam("page") @Max(50) int page, @RequestParam ("pageSize") @Max(50) int pageSize ) {
        Pageable pageable= PageRequest.of(page-1,pageSize);
        return this.addressService.findAllWithPagination(pageable);
    }

    @PutMapping("/updateAddress")
    public DataResult<List<AddressUpdatedResponse>> updatedAddres(@RequestBody @Valid AddressUpdatedRequest addressUpdatedRequest){
        return this.addressService.updateAddress(addressUpdatedRequest);
    }

    @DeleteMapping("/deleteAddress")
    public Result deleteResult(@RequestBody @Valid AddressDeletedRequest addressDeletedRequest){
        return this.addressService.deleteAddress(addressDeletedRequest);
    }

    @PostMapping("/custAddressCreated")
    public DataResult<CreateAddressWithCustomerResponse> createAddressCust(@RequestBody @Valid CreateAddressWithCustomerRequest createAddressWithCustomerRequest){
        return  this.addressService.createAddressForCustomer(createAddressWithCustomerRequest);
    }


}
