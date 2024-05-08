package com.github.leovd100.message.service.infraestructureLayer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.leovd100.message.service.domainLayer.model.Lead;
import com.github.leovd100.message.service.domainLayer.model.Message;
import com.github.leovd100.message.service.infraestructureLayer.ProducerMessageImpl;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerSms extends ProducerMessageImpl {

    public ProducerSms(AmqpTemplate amqpTemplate, ObjectMapper objectMapper, @Value("${rabbitmq.routingkey.sms}") String routingKey,
                       @Value("${rabbitmq.exchange.sms}") String exchange) {
        super(amqpTemplate, objectMapper);
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

}
