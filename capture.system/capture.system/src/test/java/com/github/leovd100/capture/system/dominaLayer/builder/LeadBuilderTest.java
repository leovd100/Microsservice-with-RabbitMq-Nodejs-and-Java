package com.github.leovd100.capture.system.dominaLayer.builder;

import com.github.leovd100.capture.system.domainLayer.dto.builder.LeadResponseDto;
import com.github.leovd100.capture.system.domainLayer.dto.builder.LeadResponseDtoBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeadBuilderTest {
    private LeadResponseDto leadResponseDto;

    @BeforeEach
    public void setUp(){
        leadResponseDto = LeadResponseDtoBuilder.builder()
                .name("name")
                .message("message").build();
    }

    @Test
    public void shouldTestToString(){
        String toString = leadResponseDto.toString();
        Assertions.assertEquals(toString, leadResponseDto.toString());
    }
}
