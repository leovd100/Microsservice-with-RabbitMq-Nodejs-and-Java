package com.github.leovd100.message.service.infraestructureLayer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.leovd100.message.service.domainLayer.model.Lead;
import com.github.leovd100.message.service.domainLayer.model.Message;
import com.github.leovd100.message.service.infraestructureLayer.exceptions.RabbitAMQPException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ProducerMessageImpl {

    Logger logger = LogManager.getLogger(ProducerMessageImpl.class);
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
            logger.info("Message sent successfully to RabbitMq " + message.getId());
        } catch (JsonProcessingException exception) {
            logger.error("Error sending request to rabbitMq {JsonProcessingException}" + exception.getMessage());
            throw new RuntimeException();
        }catch (AmqpException exception){
            logger.error("Error sending request to rabbitMq AMQP" + exception.getMessage());
            throw new RabbitAMQPException("Internal Error Server");
        }
    }
}
