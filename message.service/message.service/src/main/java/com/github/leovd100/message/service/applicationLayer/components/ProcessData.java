package com.github.leovd100.message.service.applicationLayer.components;

import com.github.leovd100.message.service.domainLayer.dto.LeadDto;
import com.github.leovd100.message.service.infraestructureLayer.service.SendMessageService;
import org.springframework.stereotype.Component;

@Component
public class ProcessData {

    private final SendMessageService sendMessageService;

    public ProcessData(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    public void sendDto(LeadDto leadDto){
        sendMessageService.sendMessages(leadDto);
    }

}
