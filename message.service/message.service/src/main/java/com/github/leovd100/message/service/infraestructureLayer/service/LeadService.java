package com.github.leovd100.message.service.infraestructureLayer.service;

import com.github.leovd100.message.service.domainLayer.entities.Lead;

public interface LeadService {
    Lead save(Lead lead);

    void undoDataLead(Lead entity);
}
