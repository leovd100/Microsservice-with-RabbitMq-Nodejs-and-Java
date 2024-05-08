package com.github.leovd100.message.service.applicationLayer.services;

import com.github.leovd100.message.service.domainLayer.model.Lead;
import com.github.leovd100.message.service.domainLayer.model.Message;

public interface SendMessageService {

    void sendMessages(Lead lead);
}
