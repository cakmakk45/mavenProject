package com.beymen.business.concretes.cam;

import com.beymen.business.dtos.requests.customer.CreateCustomerRequest;
import com.beymen.business.dtos.requests.individual.UpdateIndividualRequest;
import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.business.abstracts.cam.IIndividualService;
import com.beymen.business.constant.Messages;
import com.beymen.business.dtos.responses.individual.UpdateIndividualResponse;
import com.beymen.core.utilities.Enum.StatusCode;
import com.beymen.core.utilities.expection.business.BusinessException;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.cam.Ind;
import com.beymen.entities.concretes.cam.Party;
import com.beymen.repository.abstracs.cam.IIndividualRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IndividualManager implements IIndividualService {
    private IIndividualRepository iIndividualRepository;

    private IMessageSourceService messageSourceService;

    @Override
    public DataResult<List<Ind>> getAll() {
        return new SuccessDataResult<List<Ind>>(this.iIndividualRepository.findAll(),messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }

    @Override
    public Ind findByNationalityId(Long nationalityId) {

        Ind ind = this.iIndividualRepository.findByNatId(nationalityId);
        return ind;
    }


    @Override
    public DataResult<UpdateIndividualResponse> updateInd(UpdateIndividualRequest updateIndividualRequest) {
        Ind ind = findByNationalityId(updateIndividualRequest.getNationalityId());
        Ind willUpdate = iIndividualRepository.findByPartyPartyId(updateIndividualRequest.getPartyId());

        if (willUpdate==null){
            throw new BusinessException(messageSourceService.getMessages(Messages.CustomerMessages.customerNotFound));
        }

       checkIfIndividualExits(ind); // defensive programming

        Party party=new Party();
        party.setPartyId(updateIndividualRequest.getPartyId());

        willUpdate.setFrstName(updateIndividualRequest.getFirstName());
        willUpdate.setLstName(updateIndividualRequest.getLastName());
        willUpdate.setNatId(updateIndividualRequest.getNationalityId());
        willUpdate.setMName(updateIndividualRequest.getMiddleName());
        willUpdate.setGendrId(updateIndividualRequest.getGender());
        willUpdate.setBrthDate(updateIndividualRequest.getBirthDate());
        willUpdate.setFthrName(updateIndividualRequest.getFatherName());
        willUpdate.setMthrName(updateIndividualRequest.getMotherName());
        willUpdate.setParty(party);

        Ind individual = this.iIndividualRepository.save(willUpdate);

        UpdateIndividualResponse individualResponse = updateIndividualResponseBuilder(individual);

        return new SuccessDataResult<>(individualResponse, messageSourceService.getMessages(Messages.SuccessMessages.Updated));
    }

    @Override
    public Ind createIndividual(CreateCustomerRequest createCustomerRequest) {
        Ind ind = findByNationalityId(Long.parseLong(createCustomerRequest.getNationalityId()));
        checkIfIndividualExits(ind);

        return Ind.builder()
                .frstName(createCustomerRequest.getFirstName())
                .lstName(createCustomerRequest.getLastName())
                .mName(createCustomerRequest.getMiddleName())
                .natId(Long.parseLong(createCustomerRequest.getNationalityId()))
                .brthDate(createCustomerRequest.getBirthDate())
                .fthrName(createCustomerRequest.getFatherName())
                .mthrName(createCustomerRequest.getMotherName())
                .stId(StatusCode.IND_ACTV)
                .gendrId(createCustomerRequest.getGender())
                .build();
    }

    @Override
    public Ind addInd(Ind ind) {
        return this.iIndividualRepository.save(ind);
    }

    private UpdateIndividualResponse updateIndividualResponseBuilder(Ind individual){
        return UpdateIndividualResponse.builder()
                .firstName(individual.getFrstName())
                .lastName(individual.getLstName())
                .middleName(individual.getMName())
                .gender(individual.getGendrId())
                .birthDate(individual.getBrthDate())
                .fatherName(individual.getFthrName())
                .motherName(individual.getMthrName())
                .nationalityId(individual.getNatId()).build();
    }

    private void checkIfIndividualExits(Ind ind){
        if (ind != null) {
            throw new BusinessException(Messages.CustomerMessages.customerAlreadyExistWithNatId);
        }
    }

}
