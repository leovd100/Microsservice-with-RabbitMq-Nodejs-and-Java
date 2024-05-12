package com.github.leovd100.capture.system.infraestructureLayer.services;

import com.github.leovd100.capture.system.domainLayer.dto.LeadDto;
import com.github.leovd100.capture.system.domainLayer.dto.builder.LeadResponseDto;

public interface LeadComunicationService {
    LeadResponseDto sendData(LeadDto leadDto);
}
