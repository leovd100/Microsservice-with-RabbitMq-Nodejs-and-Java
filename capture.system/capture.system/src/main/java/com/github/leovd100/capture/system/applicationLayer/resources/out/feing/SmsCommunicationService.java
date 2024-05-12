package com.github.leovd100.capture.system.applicationLayer.resources.out.feing;

import com.github.leovd100.capture.system.domainLayer.entities.Lead;
import feign.Headers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "sms-comunication", url ="${message-service}")
public interface SmsCommunicationService {
    @PostMapping("/send-message")
    @Headers("Content-Type: application/json")
    void sendMessage(@RequestBody Lead lead);
}
