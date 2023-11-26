package com.beymen.api.controllers.order;

import com.beymen.business.abstracts.order.IBsnInterItemService;
import com.beymen.business.constant.Paths;
import com.beymen.entities.concretes.order.Bsn_Inter_Item;
import com.beymen.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"BusinessInteractionItems")
@AllArgsConstructor
public class BusinessInteractionItemController {
    private IBsnInterItemService bsnInterItemService;

    @GetMapping("/getall")
    public DataResult<List<Bsn_Inter_Item>> getAll(){
        return this.bsnInterItemService.getAll();
    }
}
