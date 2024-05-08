package com.github.leovd100.message.service.infraestructureLayer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.leovd100.message.service.domainLayer.model.Lead;
import com.github.leovd100.message.service.domainLayer.model.Message;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ProducerMessageImpl {

    protected final AmqpTemplate amqpTemplate;
    protected final ObjectMapper objectMapper;

    protected String routingKey;
    protected String exchange;

    @Autowired
    public ProducerMessageImpl(AmqpTemplate amqpTemplate, ObjectMapper objectMapper) {
        this.amqpTemplate = amqpTemplate;
        this.objectMapper = objectMapper;
    }

    public void send(Message message){
        try {
            String messageConverted = objectMapper.writeValueAsString(message);
            amqpTemplate.convertAndSend(exchange, routingKey, messageConverted);
        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
    }
}
