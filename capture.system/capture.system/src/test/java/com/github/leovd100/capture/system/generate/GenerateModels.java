package com.github.leovd100.capture.system.generate;

import com.github.leovd100.capture.system.domainLayer.dto.LeadDto;
import com.github.leovd100.capture.system.domainLayer.entities.Lead;
import com.github.leovd100.capture.system.domainLayer.model.SmsModel;
import com.github.leovd100.capture.system.domainLayer.model.StandardError;
import feign.FeignException;
import feign.Request;
import feign.RequestTemplate;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Collections;

public class GenerateModels {

    public static LeadDto generateLeadDtoForTest(){
        return new LeadDto("user@lead", "user@gmail.com", "1148448599");
    }

    public static Request generateFeignRequest(){
        return Request.create(
                Request.HttpMethod.POST,
                "http://localhost",
                Collections.emptyMap(),
                Request.Body.empty(),
                new RequestTemplate()
        );
    }

    public static FeignException generateFeignExceptionConflict(Request request){
        return new FeignException.Conflict(
                "Error Conflict",
                request,
                null
        );
    }


    public static LeadDto generateLeadDto(){
        return new LeadDto("name", "name@teste.com","11999999999");
    }

    public static Lead generateLead(){
        return new Lead("name","name@teste.com", "11999999999");
    }

    public static SmsModel generateSmsModel() {
        return new SmsModel("551199999999", "name", "congratulations");
    }

    public static StandardError generateStandardError(){
        StandardError standardError = new StandardError();
        standardError.setError("Server error");
        standardError.setPath("/customer");
        standardError.setStatus(HttpStatus.BAD_REQUEST.value());
        standardError.setMessage("Erro in server");
        standardError.setTimestamp(Instant.now());
        return standardError;
    }
}
