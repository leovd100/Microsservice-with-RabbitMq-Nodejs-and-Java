package com.github.leovd100.capture.system.dominaLayer.entities;

import com.github.leovd100.capture.system.domainLayer.entities.Lead;
import com.github.leovd100.capture.system.generate.GenerateModels;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeadTest {

    public Lead lead;

    @BeforeEach
    public void setUp(){
        lead = GenerateModels.generateLead();
    }

    public void shouldTestAttributesWhenUseSetAndGet(){
        String email = "new@teste.com";
        String name = "new";
        String phone = "977777777";

        lead.setEmail(email);
        lead.setPhone(phone);
        lead.setName(name);

        Assertions.assertEquals(email, lead.getEmail());
        Assertions.assertEquals(phone, lead.getPhone());
        Assertions.assertEquals(name, lead.getName());
    }

    @Test
    public void shouldTestToString(){
        String toString = lead.toString();
        Assertions.assertEquals(toString, lead.toString());
    }

}
