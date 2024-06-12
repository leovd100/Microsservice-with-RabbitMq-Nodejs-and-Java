package com.github.leovd100.infotoken.services;

import com.github.leovd100.infotoken.model.dto.InformationTokenDTO;
import com.github.leovd100.infotoken.model.entity.InformationEntity;
import com.github.leovd100.infotoken.repository.InfoRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.UUID;

@Singleton
public class TokenService {

    private final InfoRepository repository;

    @Inject
    public TokenService(InfoRepository repository) {
        this.repository = repository;
    }


    public InformationTokenDTO saveToken(InformationTokenDTO token){
        repository.save(toEntity(token));
        return token;
    }

    public List<InformationEntity> getAllTokens(){
        return repository.findAll();
    }

    public InformationEntity getToken(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Token not found"));
    }

    private InformationEntity toEntity(InformationTokenDTO dto){
        InformationEntity informationEntity = new InformationEntity();
        informationEntity.setToken(dto.getToken());
        return informationEntity;
    }
}
