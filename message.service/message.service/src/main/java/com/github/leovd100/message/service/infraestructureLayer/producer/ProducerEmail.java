package com.github.leovd100.message.service.infraestructureLayer.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.leovd100.message.service.infraestructureLayer.ProducerMessageImpl;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerEmail extends ProducerMessageImpl {

    public ProducerEmail(AmqpTemplate amqpTemplate, ObjectMapper objectMapper, @Value("${rabbitmq.routingkey.email}") String routingKey,
                         @Value("${rabbitmq.exchange.email}") String exchange) {
        super(amqpTemplate, objectMapper);
        this.exchange = exchange;
        this.routingKey = routingKey;
    }


}
