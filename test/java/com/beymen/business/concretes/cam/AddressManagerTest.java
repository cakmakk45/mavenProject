package com.beymen.business.concretes.cam;

import com.beymen.business.dtos.requests.address.AddressDeletedRequest;
import com.beymen.business.dtos.requests.address.CreateAddressWithCustomerRequest;
import com.beymen.core.utilities.mapping.IModelMapperService;
import com.beymen.core.utilities.mapping.ModelMapperManager;
import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.core.utilities.message.MessagesSourceManager;
import com.beymen.entities.concretes.cam.Addr;
import com.beymen.repository.abstracs.cam.IAddressRepository;
import com.beymen.business.dtos.responses.address.CreateAddressWithCustomerResponse;
import com.beymen.core.utilities.expection.business.BusinessException;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import org.modelmapper.ModelMapper;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

class AddressManagerTest {

    AddressManager addressManager;
    IAddressRepository addressRepository;
    IMessageSourceService messageSourceService;
    IModelMapperService modelMapperService;



    @BeforeEach
    void setUp() {
        // Her test öncesi çalışacak kod.
        addressRepository=mock(IAddressRepository.class);
        modelMapperService=new ModelMapperManager(new ModelMapper());
        messageSourceService=new MessagesSourceManager(getResourceBundle());


        addressManager=new AddressManager(addressRepository,modelMapperService, messageSourceService);

    }
    ResourceBundleMessageSource getResourceBundle(){
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        return source;
    }

    @Test
    void getAll() {
        // 3A Prensipi

        // Arrange,Act,Assert

        // Arrange => Testini yapacağım senaryonun bağımlılıklarını çözüyorum..
        List<Addr> addr=new ArrayList<>();
        addr.add(Addr.builder()
                        .addrId(1L)
                        .addrDesc("Ev adresi")
                        .cityName("Adana")
                        .build());


        when(addressRepository.findAll()).thenReturn(addr);

        // Act => İlgili kodların çağırıldığı ve dönüş değerlerinin beklendiği kısım..

        DataResult<List<Addr>>addr2=addressManager.getAll();

        // Assert => Expected (beklenen olgu) ile act kısmında elde edilen çıktının karşılaştırıldığı kısım..

        assert addr.size()==addr2.getData().size();
    }
    @Test
    void createAddressForCustomer() {
        CreateAddressWithCustomerRequest createAddressWithCustomerRequest= CreateAddressWithCustomerRequest.builder()
                .addressDescription("Test Desc")
                .rowId(1L)
                .city("Test City")
                .country("Test Country")
                .build();

        Addr addrToCreate= Addr.builder()
                .addrDesc("Test Desc")
                .rowId(1L)
                .cityName("Test City")
                .cntryName("Test Country")
                .build();

        when(addressRepository.save(any())).thenReturn(addrToCreate);

        CreateAddressWithCustomerResponse response= addressManager.createAddressForCustomer(createAddressWithCustomerRequest).getData();

        assert Objects.equals(response.getCity(), addrToCreate.getCityName());

    }


    @Test
    void deleteAddress() {
        AddressDeletedRequest deletedRequest= AddressDeletedRequest.builder()
                .addressId(1L)
                .build();

        Addr addrToCreate= Addr.builder()
                .addrId(1L)
                .addrDesc("Test Desc")
                .rowId(1L)
                .cityName("Test City")
                .cntryName("Test Country")
                .build();

        when(addressRepository.findById(1L)).thenReturn(Optional.ofNullable(addrToCreate));

        Result actualAddress=addressManager.deleteAddress(deletedRequest);

        assert actualAddress.isSuccess();

    }

    @Test
    void deleteAddressId_NotExist_ShouldThrowException(){
        AddressDeletedRequest deletedRequest= AddressDeletedRequest.builder()
                .addressId(1L) // Olmayan bir id girildiğinde Business Exception fırlatmasını istiyoruz.
                .build();

        assertThrows(BusinessException.class,()->{
            addressManager.deleteAddress(deletedRequest);
        });

    }


    @Test
    void updateAddress() {
    }

    @Test
    void findAllWithPagination() {
    }
}