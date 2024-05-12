package com.github.leovd100.capture.system.applicationLayer.resources;

import com.github.leovd100.capture.system.domainLayer.dto.LeadDto;
import com.github.leovd100.capture.system.domainLayer.dto.builder.LeadResponseDto;

public interface LeadService {
    LeadResponseDto sendData(LeadDto leadDto);
}
