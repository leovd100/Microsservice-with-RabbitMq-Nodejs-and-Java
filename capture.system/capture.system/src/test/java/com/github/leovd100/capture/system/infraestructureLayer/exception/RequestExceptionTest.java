package com.github.leovd100.capture.system.infraestructureLayer.exception;

import com.github.leovd100.capture.system.infraestructureLayer.exceptions.RequestException;
import com.github.leovd100.capture.system.infraestructureLayer.exceptions.UserExistsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestExceptionTest {
    @Test
    @DisplayName("Must throw an exception when calling the RequestException")
    public void shouldLauchRequestException(){
        Assertions.assertThrows(RequestException.class, ()-> {
            throw new RequestException("Request Error");
        });
    }
}
