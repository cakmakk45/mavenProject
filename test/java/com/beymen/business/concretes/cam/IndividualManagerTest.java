package com.beymen.business.concretes.cam;

import com.beymen.business.dtos.requests.individual.UpdateIndividualRequest;
import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.core.utilities.message.MessagesSourceManager;
import com.beymen.entities.concretes.cam.Ind;
import com.beymen.entities.concretes.cam.Party;
import com.beymen.repository.abstracs.cam.IIndividualRepository;
import com.beymen.business.dtos.responses.individual.UpdateIndividualResponse;
import com.beymen.core.utilities.expection.business.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Objects;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;



class IndividualManagerTest {

    // Arrange => Testini yapacağım senaryonun bağımlılıklarını çözüyorum..
    IIndividualRepository iIndividualRepository;
    IMessageSourceService iMessageSourceService;
    IndividualManager individualManager;

    @BeforeEach
    void setUp() {
        iIndividualRepository=mock(IIndividualRepository.class);
        iMessageSourceService=new MessagesSourceManager(getResourceBundle());
        individualManager = new IndividualManager(iIndividualRepository,iMessageSourceService);
    }
    ResourceBundleMessageSource getResourceBundle(){
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        return source;
    }
    @Test
    void updateInd() {

        when(iIndividualRepository.findByNatId(1L)).thenReturn(null);

        UpdateIndividualRequest updateIndividualRequest= UpdateIndividualRequest.builder()
                .firstName("Test")
                .middleName("Can")
                .lastName("Kapı")
                .partyId(6L)
                .nationalityId(1L)
                .build();


        Party party =new Party();
        party.setPartyId(6L);
        Ind willUpdate = new Ind();

        when(iIndividualRepository.findByPartyPartyId(6L)).thenReturn(willUpdate);

        willUpdate.setParty(party);
        willUpdate.setFrstName("Test");
        willUpdate.setLstName("Kapı");
        willUpdate.setNatId(2L);
        willUpdate.setMName("");
        willUpdate.setGendrId(0L);
        willUpdate.setFthrName("");
        willUpdate.setMthrName("");

        when(iIndividualRepository.save(any())).thenReturn(willUpdate);

        // Act => İlgili kodların çağırıldığı ve dönüş değerlerinin beklendiği kısım..
        UpdateIndividualResponse response =individualManager.updateInd(updateIndividualRequest).getData();

        // Assert => Expected (beklenen olgu) ile act kısmında elde edilen çıktının karşılaştırıldığı kısım..
       assert Objects.equals(response.getFirstName(), willUpdate.getFrstName());

    }

    @Test
    void updateNatId_ShouldThrow_BusinessExceptionInd() {
        when(iIndividualRepository.findByNatId(1L)).thenReturn(Ind.builder()
                .natId(1L)
                .frstName("DB")
                .lstName("Kayit")
                .mthrName("anne")
                .fthrName("baba")
                .build());

        UpdateIndividualRequest updateIndividualRequest= UpdateIndividualRequest.builder()
                .firstName("Test")
                .middleName("Can")
                .lastName("Kapı")
                .partyId(6L)
                .nationalityId(1L)
                .build();

        assertThrows(BusinessException.class, ()->{
            individualManager.updateInd(updateIndividualRequest);});
    }


    @Test
    void getAll() {
    }

    @Test
    void findByNationalityId() {
    }

    @Test
    void createIndividual() {
    }

    @Test
    void addInd() {
    }
}