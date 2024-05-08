package com.github.leovd100.capture.system.applicationLayer.resources.in;

import com.github.leovd100.capture.system.domainLayer.dto.LeadDto;
import com.github.leovd100.capture.system.domainLayer.dto.LeadResponseDto;
import com.github.leovd100.capture.system.applicationLayer.resources.LeadService;
import com.github.leovd100.capture.system.infraestructureLayer.services.LeadComunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadServiceImpl implements LeadService {

    @Autowired
    private LeadComunicationService leadComunicationService;

    public LeadResponseDto saveLead(LeadDto leadDto){
        return leadComunicationService.saveLead(leadDto);
    }

}
