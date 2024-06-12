package com.github.leovd100.infotoken.model.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class InformationTokenDTO {
    private String token;

    public InformationTokenDTO(){}

    public InformationTokenDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "InformationTokenDTO{" +
                "token='" + token + '\'' +
                '}';
    }
}
