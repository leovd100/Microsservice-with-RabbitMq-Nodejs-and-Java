package com.github.leovd100.message.service.infraestructureLayer.service;

import com.github.leovd100.message.service.domainLayer.dto.LeadDto;
import com.github.leovd100.message.service.domainLayer.model.Lead;
import com.github.leovd100.message.service.domainLayer.model.Message;

public interface SendMessageService {

    void sendMessages(LeadDto leadDto);
}
