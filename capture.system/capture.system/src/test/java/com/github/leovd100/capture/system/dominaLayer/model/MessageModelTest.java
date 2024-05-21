package com.github.leovd100.capture.system.dominaLayer.model;

import com.github.leovd100.capture.system.domainLayer.enums.TypeMessage;
import com.github.leovd100.capture.system.domainLayer.model.MessageModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class MessageModelTest {

    private MessageModel messageModel;

    @BeforeEach
    public void setUp(){
        messageModel = new MessageModel();
    }

    @Test
    public void shouldTestAllArgsContructor(){
        messageModel = new MessageModel(UUID.randomUUID(),TypeMessage.EMAIL, "new@teste.com");
        Assertions.assertNotNull(messageModel);
    }

    @Test
    public void shouldTestToString(){
        String toString = messageModel.toString();
        Assertions.assertEquals(toString, messageModel.toString());
    }


    @Test
    public void shouldTestGettersAndSetters(){
        TypeMessage sms = TypeMessage.SMS;
        UUID uuid = UUID.randomUUID();
        String email = "new@teste.com";

        messageModel.setTypeMessage(sms);
        messageModel.setId(uuid);
        messageModel.setContactValue(email);


        Assertions.assertEquals(sms, messageModel.getTypeMessage());
        Assertions.assertEquals(uuid, messageModel.getId());
        Assertions.assertEquals(email, messageModel.getContactValue());

    }


}
