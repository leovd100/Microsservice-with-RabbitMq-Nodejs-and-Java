package com.github.leovd100.infotoken.services;


import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;

@RabbitClient("${rabbitmq.exchange.token}")
public interface AMQPSend {
    @Binding("${rabbitmq.routingkey.token}")
    void send(String data);
}
