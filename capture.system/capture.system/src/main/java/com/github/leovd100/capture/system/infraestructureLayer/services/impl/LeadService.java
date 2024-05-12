package com.github.leovd100.capture.system.infraestructureLayer.services.impl;

import com.github.leovd100.capture.system.domainLayer.dto.LeadDto;
import com.github.leovd100.capture.system.domainLayer.dto.builder.LeadResponseDto;
import com.github.leovd100.capture.system.domainLayer.dto.builder.LeadResponseDtoBuilder;
import com.github.leovd100.capture.system.domainLayer.entities.Lead;
import com.github.leovd100.capture.system.infraestructureLayer.exceptions.RequestException;
import com.github.leovd100.capture.system.infraestructureLayer.services.LeadComunicationService;
import com.github.leovd100.capture.system.applicationLayer.resources.out.feing.SmsCommunicationService;
import feign.FeignException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadService implements LeadComunicationService {
    Logger logger = LogManager.getLogger(LeadService.class);
    private final SmsCommunicationService communicationService;

    @Autowired
    public LeadService(SmsCommunicationService communicationService) {
        this.communicationService = communicationService;
    }

    @Override
    public LeadResponseDto sendData(LeadDto leadDto) {
        try {
            Lead lead = new Lead(leadDto);
            communicationService.sendMessage(lead);
            logger.info("User %s successfully registered!".formatted(lead.getName()));
            return leadtoLeadResponseDto(lead);
        }catch (FeignException exception){
            logger.error("Request error. Unable to communicate with the messaging service.");
            throw new RequestException("Request error. Unable to communicate with the messaging service.");
        }
    }

    public LeadResponseDto leadtoLeadResponseDto(Lead lead){
       return LeadResponseDtoBuilder.builder().name(lead.getName()).message("successfully registered!").build();
    }
}
