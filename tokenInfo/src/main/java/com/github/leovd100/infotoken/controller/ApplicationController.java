package com.github.leovd100.infotoken.controller;

import com.github.leovd100.infotoken.model.dto.InformationTokenDTO;
import com.github.leovd100.infotoken.model.entity.InformationEntity;
import com.github.leovd100.infotoken.services.TokenService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

import static io.micronaut.http.MediaType.APPLICATION_JSON;
@Validated
@Controller("/info")
public class ApplicationController {

    private final TokenService tokenService;

    @Inject
    public ApplicationController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Post(produces= APPLICATION_JSON)
    public HttpResponse<InformationTokenDTO> saveToken(@Body @Valid InformationTokenDTO token){
        return HttpResponse.ok().body(tokenService.saveToken(token));
    }

    @Get(produces= APPLICATION_JSON)
    public HttpResponse<List<InformationEntity>> getAllTokens(){
        return HttpResponse.ok().body(tokenService.getAllTokens());
    }

    @Get(uri="/find", produces= APPLICATION_JSON)
    public HttpResponse<InformationEntity> getTokenById(@QueryValue UUID id){
        return HttpResponse.ok().body(tokenService.getToken(id));
    }

}
