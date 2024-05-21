package com.github.leovd100.capture.system.dominaLayer.dto;

import com.github.leovd100.capture.system.domainLayer.dto.LeadDto;
import com.github.leovd100.capture.system.generate.GenerateModels;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeadDtoTest {

    private LeadDto leadDto;

    @BeforeEach
    public void setUp(){
        leadDto = GenerateModels.generateLeadDto();
    }

    @Test
    public void shoulCheckIfAttributesAreInsert(){
        LeadDto entity = GenerateModels.generateLeadDto();
        Assertions.assertEquals(entity.getName(), leadDto.getName());
        Assertions.assertEquals(entity.getEmail(), leadDto.getEmail());
        Assertions.assertEquals(entity.getPhone(), leadDto.getPhone());
    }

    @Test
    public void shoulTestAttributesWhenInsertWithSet(){
        String email = "new@teste.com";
        String name = "new";
        String phone = "977777777";

        leadDto.setEmail(email);
        leadDto.setPhone(phone);
        leadDto.setName(name);

        Assertions.assertEquals(email, leadDto.getEmail());
        Assertions.assertEquals(phone, leadDto.getPhone());
        Assertions.assertEquals(name, leadDto.getName());
    }


    @Test
    public void shouldTestToString(){
        String toString = leadDto.toString();
        Assertions.assertEquals(toString, leadDto.toString());
    }

    @Test
    public void shouldTestNoArgsConstructor(){
        LeadDto lead = new LeadDto();
        Assertions.assertNotNull(lead);
    }
}
