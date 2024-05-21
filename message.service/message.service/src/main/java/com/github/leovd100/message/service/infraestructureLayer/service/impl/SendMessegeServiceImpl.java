package com.github.leovd100.message.service.infraestructureLayer.service.impl;

import com.github.leovd100.message.service.applicationLayer.components.ModelMapperComponent;
import com.github.leovd100.message.service.infraestructureLayer.exceptions.RabbitAMQPException;
import com.github.leovd100.message.service.infraestructureLayer.service.LeadService;
import com.github.leovd100.message.service.infraestructureLayer.service.SendMessageService;
import com.github.leovd100.message.service.domainLayer.dto.LeadDto;
import com.github.leovd100.message.service.domainLayer.enums.TypeMessage;
import com.github.leovd100.message.service.domainLayer.entities.Lead;
import com.github.leovd100.message.service.domainLayer.model.Message;
import com.github.leovd100.message.service.infraestructureLayer.producer.ProducerEmail;
import com.github.leovd100.message.service.infraestructureLayer.producer.ProducerSms;
import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SendMessegeServiceImpl implements SendMessageService {

    private final ProducerSms producerSms;
    private final ProducerEmail producerEmail;
    private final ModelMapperComponent modelMapper;

    private final LeadService leadService;
    @Autowired
    public SendMessegeServiceImpl(ProducerSms producerSms, ProducerEmail producerEmail, ModelMapperComponent modelMapper, LeadServiceImpl leadService) {
        this.producerSms = producerSms;
        this.producerEmail = producerEmail;
        this.modelMapper = modelMapper;
        this.leadService = leadService;
    }

    @Transactional
    public void sendMessages(LeadDto leadDto) throws RuntimeException{
        Lead entity = modelMapper.toLead(leadDto);
        entity = leadService.save(entity);
        try {
            producerSms.send(generateMessageWithType(TypeMessage.SMS, entity));
            producerEmail.send(generateMessageWithType(TypeMessage.EMAIL, entity));
        }catch (AmqpException exception){
            leadService.undoDataLead(entity);
            throw new RabbitAMQPException("Erro to send message for RabbitMq");
        }
    }

    private Message  generateMessageWithType(TypeMessage typeMessage, Lead lead){
        return new Message(lead, typeMessage);
    }

}
