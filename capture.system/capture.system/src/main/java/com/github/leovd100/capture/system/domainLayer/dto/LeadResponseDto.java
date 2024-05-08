package com.github.leovd100.capture.system.domainLayer.dto;

import lombok.Data;

@Data
public class LeadResponseDto {

    private String name;

    private String message;
    private LeadResponseDto(){
    }
    public static LeadResponseDto builder(){
        return new LeadResponseDto();
    }

    public LeadResponseDto name(String name){
        this.name = name;
        return this;
    }

    public LeadResponseDto messsage(String message){
        this.message = message;
        return this;
    }

}
