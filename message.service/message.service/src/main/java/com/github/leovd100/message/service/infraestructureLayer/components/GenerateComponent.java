package com.github.leovd100.message.service.infraestructureLayer.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.leovd100.message.service.domainLayer.model.HashObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class GenerateComponent {

    private final String urlBase;
    private final ObjectMapper objectMapper;

    public GenerateComponent( @Value("${url.base}") String urlBase, ObjectMapper objectMapper) {
        this.urlBase = urlBase;
        this.objectMapper = objectMapper;
    }

    public String linkGen(HashObject hashObject){
        String url = urlBase + "?dch="+ bodyURL(hashObject);
        System.out.println(url);
        return url;
    }

    private String bodyURL(HashObject hashObject){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        String firstPart = generateBody(alphabet, 3);
        String secondPart = generateBody(alphabet + numbers, 5);
        String thPart = generateBody(numbers, 4);
        String hashInfo = "%s-%s-%s".formatted(firstPart, secondPart, thPart);
        hashObject.setHashInfo(hashInfo);
        String json = generateJson(hashObject);
        String encodedString = Base64.getEncoder().encodeToString(json.getBytes());

        return encodedString;
    }

    private String generateJson(HashObject hashObject){
        try {
           return objectMapper.writeValueAsString(hashObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }



    private String generateBody(String charSet,Integer length){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(charSet.charAt(((int) Math.floor(Math.random() * charSet.length()))));
        }
        return result.toString();
    }



}
