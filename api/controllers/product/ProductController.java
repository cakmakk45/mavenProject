package com.beymen.api.controllers.product;

import com.beymen.business.abstracts.product.IProductService;
import com.beymen.entities.concretes.prod.Prod;
import com.beymen.business.constant.Paths;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"products")
@AllArgsConstructor
public class ProductController {
    private IProductService productService;

    @GetMapping("/getall")
    public DataResult<List<Prod>> getAll(){
        return this.productService.getAll();
    }

    @GetMapping("/getAllWithPagination")
    public DataResult<Page<List<Prod>>> getAllWithPagination(@RequestParam("page") @Max(50) int page, @RequestParam("pageSize") @Max(50) int pageSize) {
        Pageable pageable= PageRequest.of(page-1,pageSize);
        return this.productService.findAllWithPagination(pageable);
    }
}
