package com.github.leovd100.message.service.applicationLayer.services.impl;

import com.github.leovd100.message.service.applicationLayer.services.SendMessageService;
import com.github.leovd100.message.service.domainLayer.enums.TypeMessage;
import com.github.leovd100.message.service.domainLayer.model.Lead;
import com.github.leovd100.message.service.domainLayer.model.Message;
import com.github.leovd100.message.service.infraestructureLayer.producer.ProducerEmail;
import com.github.leovd100.message.service.infraestructureLayer.producer.ProducerSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendMessegeServiceImpl implements SendMessageService {

    private final ProducerSms producerSms;
    private final ProducerEmail producerEmail;
    @Autowired
    public SendMessegeServiceImpl(ProducerSms producerSms, ProducerEmail producerEmail) {
        this.producerSms = producerSms;
        this.producerEmail = producerEmail;
    }

    public void sendMessages(Lead lead){
        Message smsMessage = new Message(lead, TypeMessage.SMS);
        Message emailMessage = new Message(lead, TypeMessage.EMAIL);
        producerSms.send(smsMessage);
        producerEmail.send(emailMessage);
    }



}
