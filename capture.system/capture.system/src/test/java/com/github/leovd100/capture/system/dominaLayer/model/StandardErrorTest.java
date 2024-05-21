package com.github.leovd100.capture.system.dominaLayer.model;

import com.github.leovd100.capture.system.domainLayer.model.StandardError;
import com.github.leovd100.capture.system.generate.GenerateModels;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.Instant;

public class StandardErrorTest {

    StandardError standardError;

    @BeforeEach
    private void setUp(){
        standardError = GenerateModels.generateStandardError();
    }

    @Test
    public void shouldTestInsertAttrubutsInStandardError(){
        Instant instant = Instant.now();
        String message = "Error: error in url http://localhost";
        HttpStatus status = HttpStatus.BAD_GATEWAY;
        String path = "/customer";
        standardError = new StandardError();
        standardError.setTimestamp(instant);
        standardError.setMessage(message);
        standardError.setStatus(status.value());
        standardError.setPath(path);

        Assertions.assertEquals(instant, standardError.getTimestamp());
        Assertions.assertEquals(message, standardError.getMessage());
        Assertions.assertEquals(path, standardError.getPath());
        Assertions.assertEquals(status.value(), standardError.getStatus());


    }

}
