package com.github.leovd100.message.service.infraestructureLayer.exceptions;

import org.springframework.amqp.AmqpException;

public class RabbitAMQPException extends AmqpException {

    public RabbitAMQPException(String message) {
        super(message);
    }
}
