package com.github.leovd100.message.service.infraestructureLayer.service;

import com.github.leovd100.message.service.domainLayer.dto.LeadDto;

public interface SendMessageService {

    void sendMessages(LeadDto leadDto);
}
