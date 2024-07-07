package com.github.leovd100.infotoken.services;

import com.github.leovd100.infotoken.model.entity.InformationEntity;
import io.micronaut.rabbitmq.exception.RabbitClientException;
import io.micronaut.serde.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.io.IOException;

@Singleton
public class AMQPService {

    private final ObjectMapper objectMapper;
    private final AMQPSend amqpSend;
    @Inject
    public AMQPService(ObjectMapper objectMapper, AMQPSend amqpSend) {
        this.objectMapper = objectMapper;
        this.amqpSend = amqpSend;
    }

    public void sendMessage(InformationEntity entity) throws IOException {
        try {
            String json = objectMapper.writeValueAsString(entity);
            amqpSend.send(json);
        }catch (IOException  |RabbitClientException e){
            e.getMessage();
        }
    }

}
