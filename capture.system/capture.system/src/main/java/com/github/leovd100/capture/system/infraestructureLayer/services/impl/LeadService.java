package com.github.leovd100.capture.system.infraestructureLayer.services.impl;

import com.github.leovd100.capture.system.domainLayer.dto.LeadDto;
import com.github.leovd100.capture.system.domainLayer.dto.LeadResponseDto;
import com.github.leovd100.capture.system.infraestructureLayer.services.SmsCommunicationService;
import com.github.leovd100.capture.system.domainLayer.entities.Lead;
import com.github.leovd100.capture.system.infraestructureLayer.services.LeadComunicationService;
import com.github.leovd100.capture.system.infraestructureLayer.repositories.LeadRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.ConnectException;

@Service
public class LeadService implements LeadComunicationService {


    private final LeadRepository repository;
    private final SmsCommunicationService communicationService;

    @Autowired
    public LeadService(LeadRepository repository, SmsCommunicationService communicationService) {
        this.repository = repository;
        this.communicationService = communicationService;
    }

    @Override
    public LeadResponseDto saveLead(LeadDto leadDto) {

        Lead lead = repository.save(new Lead(leadDto));
        communicationService.sendMessage(lead);
        return toLeadResponseDto(lead);


    }

    public LeadResponseDto toLeadResponseDto(Lead lead ){
       return LeadResponseDto.builder().name(lead.getName()).messsage("Cadastrado com sucesso!");
    }
}
