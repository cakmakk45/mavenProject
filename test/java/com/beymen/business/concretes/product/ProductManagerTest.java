package com.beymen.business.concretes.product;

import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.core.utilities.message.MessagesSourceManager;
import com.beymen.entities.concretes.prod.Prod;
import com.beymen.repository.abstracs.prod.IProductRepository;
import com.beymen.core.utilities.results.DataResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.domain.Page;


import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

class ProductManagerTest {
    ProductManager productManager;
    IProductRepository productRepository;
    IMessageSourceService messageSourceService;

    @BeforeEach
    void setUp() {
        productRepository=mock(IProductRepository.class);

        messageSourceService=new MessagesSourceManager(getResourceBundle());

        productManager=new ProductManager(productRepository,messageSourceService);

    }

    ResourceBundleMessageSource getResourceBundle(){
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        return source;
    }

    @Test
    void getAll() {
        List<Prod> productsToReturn=new ArrayList<>();
        productsToReturn.add(Prod.builder()
                        .name("Deneme Prod")
                        .prodId(1L)
                        .descr("Test Deneme Product")
                        .build());

        when(productRepository.findAll()).thenReturn(productsToReturn);

        DataResult<List<Prod>> actualResult=productManager.getAll();

        assert productsToReturn.size()==actualResult.getData().size();

    }

    @Test
    void findAllWithPagination() {
        // TODO: Pagination test bakılacak


        List<Prod> productsToReturn=new ArrayList<>();
        productsToReturn.add(Prod.builder()
                .name("Deneme Prod")
                .prodId(1L)
                .descr("Test Deneme Product")
                .build());


       // when(productRepository.getAllWithPagination(Mockito.anyString(),Mockito.any())).thenReturn(productsToReturn);

        DataResult<Page<List<Prod>>> actualResult= null;

        assert productsToReturn.size()==actualResult.getData().getTotalPages();
    }
}