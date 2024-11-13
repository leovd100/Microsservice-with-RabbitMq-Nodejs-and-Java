package com.github.leovd100.infotoken;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@OpenAPIDefinition(
    info = @Info(
            title = "Information token",
            version = "0.0"
    )
)
public class Application {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Application.class);
        Micronaut.run(Application.class, args);
        logger.info("[======= INICIANDO APLICAÇÂO TOKEN CONVERT PROCESSOR =======]");

    }
}