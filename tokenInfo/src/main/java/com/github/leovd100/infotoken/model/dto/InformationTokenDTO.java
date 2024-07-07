package com.github.leovd100.infotoken.model.dto;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Size;


@Serdeable
public class InformationTokenDTO {
    @Size(min = 20, message = "Token needs to be bigger")
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
