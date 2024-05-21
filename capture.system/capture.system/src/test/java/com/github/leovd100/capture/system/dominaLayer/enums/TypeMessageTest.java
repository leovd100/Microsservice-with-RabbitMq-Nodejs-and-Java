package com.github.leovd100.capture.system.dominaLayer.enums;

import com.github.leovd100.capture.system.domainLayer.enums.TypeMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TypeMessageTest {

    @Test
    public void shouldTestTypeMessageEnum(){
        TypeMessage typeMessageEmail = TypeMessage.valueOf("EMAIL");
        TypeMessage typeMessageSMS = TypeMessage.valueOf("SMS");
        Assertions.assertEquals(typeMessageEmail, TypeMessage.EMAIL);
        Assertions.assertEquals(typeMessageSMS, TypeMessage.SMS);

    }
}
