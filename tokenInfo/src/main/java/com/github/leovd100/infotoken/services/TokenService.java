package com.github.leovd100.infotoken.services;

import com.github.leovd100.infotoken.exceptions.TokenException;
import com.github.leovd100.infotoken.model.dto.InformationTokenDTO;
import com.github.leovd100.infotoken.model.entity.InformationEntity;
import com.github.leovd100.infotoken.repository.InfoRepository;
import io.micronaut.serde.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Singleton
public class TokenService {

    private final InfoRepository repository;
    private final ObjectMapper objectMapper;
    private final AMQPService amqpService;
    @Inject
    public TokenService(InfoRepository repository, ObjectMapper objectMapper, AMQPService amqpService) {
        this.repository = repository;
        this.objectMapper = objectMapper;
        this.amqpService = amqpService;
    }


    public InformationTokenDTO saveToken(InformationTokenDTO token) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(token.getToken());
            InformationEntity providerInfo = objectMapper.readValue(decodedBytes, InformationEntity.class);
            providerInfo.setToken(token.getToken());
            //repository.save(providerInfo);
            amqpService.sendMessage(providerInfo);
            return token;
        }catch (IOException ioex){
            ioex.getMessage();
        }
        return null;
    }

    public List<InformationEntity> getAllTokens(){
        return repository.findAll();
    }

    public InformationEntity getToken(UUID id){
        return repository.findById(id).orElseThrow(() -> new TokenException("Token not found"));
    }

    private InformationEntity toEntity(InformationTokenDTO dto){
        InformationEntity informationEntity = new InformationEntity();
        informationEntity.setToken(dto.getToken());
        return informationEntity;
    }
}
