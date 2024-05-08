package com.github.leovd100.capture.system.infraestructureLayer.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.leovd100.capture.system.infraestructureLayer.services.SmsCommunicationService;
import com.github.leovd100.capture.system.domainLayer.entities.Lead;
import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SmsService implements SmsCommunicationService {

    String url = "http://localhost:8081/send-message";


    @Override
    public void sendMessage(Lead lead) {
            Gson gson = new Gson();
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(gson.toJson(lead), headers);
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
    }


}
