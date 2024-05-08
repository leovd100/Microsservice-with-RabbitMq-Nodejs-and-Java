package com.github.leovd100.capture.system.applicationLayer.resources;

import com.github.leovd100.capture.system.domainLayer.dto.LeadDto;
import com.github.leovd100.capture.system.domainLayer.dto.LeadResponseDto;

public interface LeadService {

    LeadResponseDto saveLead(LeadDto leadDto);
}
