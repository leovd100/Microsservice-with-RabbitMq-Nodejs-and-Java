package com.github.leovd100.capture.system.infraestructureLayer.exception;

import com.github.leovd100.capture.system.infraestructureLayer.exceptions.UserExistsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserExistsExceptionTest {

    @Test
    @DisplayName("Must throw an exception when calling the UserExistsException")
    public void shouldLauchUserExistsException(){
        Assertions.assertThrows(UserExistsException.class, ()-> {
           throw new UserExistsException("User email already exists in database");
        });
    }

}
