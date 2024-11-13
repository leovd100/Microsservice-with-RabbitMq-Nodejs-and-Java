package com.github.leovd100.infotoken.controller;

import com.github.leovd100.infotoken.model.dto.InformationTokenDTO;
import com.github.leovd100.infotoken.model.entity.InformationEntity;
import com.github.leovd100.infotoken.services.TokenService;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import io.micronaut.http.server.cors.CrossOrigin;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

import static io.micronaut.http.MediaType.APPLICATION_JSON;

@Controller("/info")
@CrossOrigin(allowedOrigins = "*")
public class ApplicationController {

    private final TokenService tokenService;

    Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @Inject
    public ApplicationController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Post(consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public HttpResponse<InformationTokenDTO> saveToken(@Body InformationTokenDTO token){
        logger.info("Iniciando processamento de token");
        return HttpResponse.created(tokenService.saveToken(token));
    }


}
