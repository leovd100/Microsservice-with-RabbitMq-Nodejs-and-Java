package com.github.leovd100.capture.system.infraestructureLayer.services;

import com.github.leovd100.capture.system.domainLayer.dto.LeadDto;
import com.github.leovd100.capture.system.domainLayer.dto.LeadResponseDto;

public interface LeadComunicationService {
    LeadResponseDto saveLead(LeadDto leadDto);
}
