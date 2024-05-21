package com.github.leovd100.capture.system.applicationLayer.resource.in;

import com.github.leovd100.capture.system.applicationLayer.resources.in.LeadServiceImpl;
import com.github.leovd100.capture.system.domainLayer.dto.LeadDto;
import com.github.leovd100.capture.system.domainLayer.dto.builder.LeadResponseDto;
import com.github.leovd100.capture.system.generate.GenerateModels;
import com.github.leovd100.capture.system.infraestructureLayer.services.LeadComunicationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LeadServiceImplTest {

    @InjectMocks
    private LeadServiceImpl leadService;
    @Mock
    private LeadComunicationService leadComunicationService;

    private LeadDto leadDto;

    @BeforeEach
    public void setUp(){
        leadDto = GenerateModels.generateLeadDto();
        Mockito.when(leadComunicationService.sendData(Mockito.any())).thenReturn(new LeadResponseDto("name", "successfully registered!"));
    }


    @Test
    public void shouldReturnALeadResponseDtoWhenSendALeadDto(){
        LeadResponseDto leadResponseDto =  leadService.sendData(leadDto);
        Assertions.assertNotNull(leadResponseDto);
        Assertions.assertEquals(leadResponseDto.name(), "name");
    }


}
