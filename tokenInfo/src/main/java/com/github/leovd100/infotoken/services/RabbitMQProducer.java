package com.github.leovd100.infotoken.services;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import io.micronaut.context.annotation.Value;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Singleton;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


@Singleton
public class RabbitMQProducer {
    private final Channel channel;
    private final String exchange;
    private final String routingKey;
    public RabbitMQProducer(Connection connection,
                            @Value("${rabbitmq.exchange.token:token-exchange}") String exchange,
                            @Value("${rabbitmq.routingkey.token:token-routing-key}") String routingKey) throws IOException {
        // Criando o canal a partir da conexão injetada
        this.channel = connection.createChannel();
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    public void publishMessage(String message) throws IOException {
        // Define o flag mandatory como true
        channel.basicPublish(exchange, routingKey, true, null, message.getBytes());
    }

    @PreDestroy
    public void close() throws IOException, TimeoutException {
        if (channel != null && channel.isOpen()) {
            channel.close();
        }
    }
}