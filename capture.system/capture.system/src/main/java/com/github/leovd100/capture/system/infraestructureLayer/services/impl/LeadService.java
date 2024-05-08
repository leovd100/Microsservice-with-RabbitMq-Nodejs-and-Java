package com.github.leovd100.capture.system.infraestructureLayer.services.impl;

import com.github.leovd100.capture.system.domainLayer.dto.LeadDto;
import com.github.leovd100.capture.system.domainLayer.dto.LeadResponseDto;
import com.github.leovd100.capture.system.infraestructureLayer.exceptions.DataBaseException;
import com.github.leovd100.capture.system.infraestructureLayer.services.SmsCommunicationService;
import com.github.leovd100.capture.system.domainLayer.entities.Lead;
import com.github.leovd100.capture.system.infraestructureLayer.services.LeadComunicationService;
import com.github.leovd100.capture.system.infraestructureLayer.repositories.LeadRepository;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class LeadService implements LeadComunicationService {

    @Autowired
    private LeadRepository repository;

    @Autowired
    private SmsCommunicationService communicationService;

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
