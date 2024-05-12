package com.github.leovd100.message.service.infraestructureLayer.service.impl;

import com.github.leovd100.message.service.domainLayer.model.Lead;
import com.github.leovd100.message.service.infraestructureLayer.repositories.LeadRepository;
import com.github.leovd100.message.service.infraestructureLayer.service.LeadService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadServiceImpl implements LeadService {
    Logger logger = LogManager.getLogger(LeadServiceImpl.class);
    private final LeadRepository leadRepository;

    @Autowired
    public LeadServiceImpl(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public Lead save(Lead lead){
        lead = leadRepository.save(lead);
        logger.info("Dados salvos com sucesso! " + lead.getId().toString());
        return lead;
    }



}
