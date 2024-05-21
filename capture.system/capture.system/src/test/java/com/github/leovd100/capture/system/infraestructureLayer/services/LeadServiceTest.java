package com.github.leovd100.capture.system.infraestructureLayer.services;

import com.github.leovd100.capture.system.applicationLayer.resources.out.feing.SmsCommunicationService;
import com.github.leovd100.capture.system.domainLayer.dto.LeadDto;
import com.github.leovd100.capture.system.domainLayer.dto.builder.LeadResponseDto;
import com.github.leovd100.capture.system.infraestructureLayer.exceptions.RequestException;
import com.github.leovd100.capture.system.infraestructureLayer.exceptions.UserExistsException;
import com.github.leovd100.capture.system.generate.GenerateModels;
import com.github.leovd100.capture.system.infraestructureLayer.services.impl.LeadService;
import feign.FeignException;
import feign.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LeadServiceTest {

    @InjectMocks
    private LeadService leadService;
    @Mock
    private SmsCommunicationService smsCommunicationService;
    private LeadDto leadDto = null;

    @BeforeEach
    private void setUp(){
        leadDto = GenerateModels.generateLeadDtoForTest();
    }

    @Test
    @DisplayName("Should return a responseDto when send data of leaddto")
    public void shouldReturnLeadResponseDtoWhenSendData(){
        Mockito.doNothing().when(smsCommunicationService).sendMessage(Mockito.any());
        LeadResponseDto leadResponseDto = leadService.sendData(leadDto);

        Assertions.assertEquals(leadResponseDto.name(), leadDto.getName());

        Assertions.assertNotNull(leadResponseDto.message());
    }

    @Test
    @DisplayName("should return an error when trying to send the LeadDto")
    public void shouldThrowAnErroWhenTryToSendLeadDto(){
        Mockito.doThrow(FeignException.class).when(smsCommunicationService).sendMessage(Mockito.any());
        Assertions.assertThrows(RequestException.class, () -> {
            LeadResponseDto leadResponseDto = leadService.sendData(leadDto);
        });
    }


    @Test
    @DisplayName("should return an error when trying to send the LeadDto")
    public void shouldThrowAnErroWhenReturnAFeignExeptionStatus409(){
        Request request = GenerateModels.generateFeignRequest();
        FeignException feignException = GenerateModels.generateFeignExceptionConflict(request);

        Mockito.doThrow(feignException).when(smsCommunicationService).sendMessage(Mockito.any());

        Assertions.assertThrows(UserExistsException.class, () -> {
            LeadResponseDto leadResponseDto = leadService.sendData(leadDto);
        });
    }
}
