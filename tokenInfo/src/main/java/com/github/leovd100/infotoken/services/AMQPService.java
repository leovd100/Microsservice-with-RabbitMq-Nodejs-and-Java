package com.github.leovd100.infotoken.services;

import com.github.leovd100.infotoken.model.entity.InformationEntity;
import io.micronaut.rabbitmq.exception.RabbitClientException;
import io.micronaut.serde.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Singleton
public class AMQPService {

    Logger logger = LoggerFactory.getLogger(AMQPService.class);
    private final ObjectMapper objectMapper;
    private final RabbitMQProducer amqpSend;
    @Inject
    public AMQPService(ObjectMapper objectMapper, RabbitMQProducer amqpSend) {
        this.objectMapper = objectMapper;
        this.amqpSend = amqpSend;
    }

    public void sendMessage(InformationEntity entity) throws IOException {
        try {
            logger.info("Enviando dados...");
            String json = objectMapper.writeValueAsString(entity);
            amqpSend.publishMessage(json);
            logger.info("Enviado com sucesso!");

        }catch (IOException  |RabbitClientException e){
            logger.error("Error: " + e.getMessage());
        }
    }

}
