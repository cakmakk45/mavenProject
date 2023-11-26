package com.beymen.business.concretes.cam;

import com.beymen.business.dtos.requests.contactMedium.ContactMediumUpdatedRequest;
import com.beymen.core.utilities.message.IMessageSourceService;
import com.beymen.repository.abstracs.cam.IContactMediumRepository;
import com.beymen.business.abstracts.cam.IContactMediumService;
import com.beymen.business.constant.Messages;
import com.beymen.business.dtos.responses.contactMedium.ContactMediumUpdatedResponse;
import com.beymen.core.utilities.Enum.ContactMediumTypes;
import com.beymen.core.utilities.Enum.StatusCode;
import com.beymen.core.utilities.Enum.TypeValues;
import com.beymen.core.utilities.results.DataResult;
import com.beymen.core.utilities.results.SuccessDataResult;
import com.beymen.entities.concretes.cam.CntcMedium;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ContactMediumManager implements IContactMediumService {
    private IContactMediumRepository iContactMediumRepository;
    private IMessageSourceService messageSourceService;
    @Override
    public DataResult<List<CntcMedium>>getAll() {
        return new SuccessDataResult<>
                (this.iContactMediumRepository.findAll(),messageSourceService.getMessages(Messages.SuccessMessages.Listall));
    }

    @Override
    public DataResult<ContactMediumUpdatedResponse> contactMediumUpdateCustomer
            (ContactMediumUpdatedRequest contactMediumUpdatedRequest) {

        //Contact Medium Gereksinimleri Set Edildi
        CntcMedium contactMediumGsmNo = cntcMediumGsmNoBuilder(contactMediumUpdatedRequest);
        CntcMedium contactMediumEmail = cntcMediumEmailBuilder(contactMediumUpdatedRequest);
        CntcMedium contactMediumHomePhone = cntcMediumHomePhoneBuilder(contactMediumUpdatedRequest);
        CntcMedium contactMediumFax = cntcMediumFaxBuilder(contactMediumUpdatedRequest);

        List<CntcMedium> contactInfoList = new ArrayList<>();
        contactInfoList.add(contactMediumEmail);
        contactInfoList.add(contactMediumFax);
        contactInfoList.add(contactMediumHomePhone);
        contactInfoList.add(contactMediumGsmNo);

        this.iContactMediumRepository.saveAll(contactInfoList);

        ContactMediumUpdatedResponse response = contactMediumUpdatedResponseBuilder(contactMediumGsmNo,
                contactMediumEmail,contactMediumHomePhone,contactMediumFax);

        return new SuccessDataResult<>(response,messageSourceService.getMessages(Messages.SuccessMessages.Updated));
    }

    private ContactMediumUpdatedResponse contactMediumUpdatedResponseBuilder(CntcMedium contactMediumGsmNo,
                                                                             CntcMedium contactMediumEmail,
                                                                             CntcMedium contactMediumHomePhone,
                                                                             CntcMedium contactMediumFax){
        return ContactMediumUpdatedResponse.builder()
                .eMail(contactMediumEmail.getCntcData())
                .fax(contactMediumFax.getCntcData())
                .homePhone(contactMediumHomePhone.getCntcData())
                .mobilePhone(contactMediumGsmNo.getCntcData())
                .build();
    }

    private CntcMedium cntcMediumGsmNoBuilder(ContactMediumUpdatedRequest contactMediumUpdatedRequest){

        return CntcMedium.builder()
                .cntcMediumTpId(ContactMediumTypes.GSM)
                .cntcData(contactMediumUpdatedRequest.getMobilePhone())
                .rowId(contactMediumUpdatedRequest.getRowId())
                .dataTpId(TypeValues.PARTY)
                .stId(StatusCode.CNTC_MEDIUM_ACTV)
                .build();

    }

    private CntcMedium cntcMediumHomePhoneBuilder(ContactMediumUpdatedRequest contactMediumUpdatedRequest) {

        return CntcMedium.builder()
                .cntcMediumTpId(ContactMediumTypes.PSTN)
                .cntcData(contactMediumUpdatedRequest.getHomePhone())
                .rowId(contactMediumUpdatedRequest.getRowId())
                .dataTpId(TypeValues.PARTY)
                .stId(StatusCode.CNTC_MEDIUM_ACTV)
                .build();

    }

    private CntcMedium cntcMediumFaxBuilder(ContactMediumUpdatedRequest contactMediumUpdatedRequest) {

        return CntcMedium.builder()
                .cntcMediumTpId(ContactMediumTypes.FAX)
                .cntcData(contactMediumUpdatedRequest.getFax())
                .rowId(contactMediumUpdatedRequest.getRowId())
                .dataTpId(TypeValues.PARTY)
                .stId(StatusCode.CNTC_MEDIUM_ACTV)
                .build();

    }

    private CntcMedium cntcMediumEmailBuilder(ContactMediumUpdatedRequest contactMediumUpdatedRequest) {

        return CntcMedium.builder()
                .cntcMediumTpId(ContactMediumTypes.EML)
                .cntcData(contactMediumUpdatedRequest.getEMail())
                .rowId(contactMediumUpdatedRequest.getRowId())
                .dataTpId(TypeValues.PARTY)
                .stId(StatusCode.CNTC_MEDIUM_ACTV)
                .build();
    }
}
