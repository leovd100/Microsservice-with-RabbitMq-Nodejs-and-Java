package com.github.leovd100.capture.system.dominaLayer.model;

import com.github.leovd100.capture.system.domainLayer.model.SmsModel;
import com.github.leovd100.capture.system.generate.GenerateModels;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SmsModelTest {

    SmsModel smsModel;

    @BeforeEach
    private void setUp(){
        smsModel = GenerateModels.generateSmsModel();
    }

    @Test
    public void shouldTestGettersAndSetters(){
        smsModel = new SmsModel();

        smsModel.setName("new name");
        smsModel.setPhoneNumber("551177777777");
        smsModel.setMessage("new message");

        Assertions.assertEquals("new name", smsModel.getName());
        Assertions.assertEquals("551177777777", smsModel.getPhoneNumber());
        Assertions.assertEquals("new message", smsModel.getMessage());
    }
}
