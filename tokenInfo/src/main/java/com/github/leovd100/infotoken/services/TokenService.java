package com.github.leovd100.infotoken.services;

import com.github.leovd100.infotoken.model.dto.InformationTokenDTO;
import com.github.leovd100.infotoken.model.entity.InformationEntity;
import io.micronaut.serde.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Base64;

@Singleton
public class TokenService {


    private final ObjectMapper objectMapper;
    private final AMQPService amqpService;

    Logger log = LoggerFactory.getLogger(TokenService.class);
    @Inject
    public TokenService(ObjectMapper objectMapper, AMQPService amqpService) {
        this.objectMapper = objectMapper;
        this.amqpService = amqpService;
    }


    public InformationTokenDTO saveToken(InformationTokenDTO token) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(token.getToken());
            InformationEntity providerInfo = objectMapper.readValue(decodedBytes, InformationEntity.class);
            providerInfo.setToken(token.getToken());
            log.info("Enviando token para fila");
            amqpService.sendMessage(providerInfo);
            return token;
        }catch (RuntimeException ex){
            log.info(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private InformationEntity toEntity(InformationTokenDTO dto){
        InformationEntity informationEntity = new InformationEntity();
        informationEntity.setToken(dto.getToken());
        return informationEntity;
    }
}
