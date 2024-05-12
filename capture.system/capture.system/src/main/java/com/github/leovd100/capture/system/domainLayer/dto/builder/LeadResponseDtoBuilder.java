package com.github.leovd100.capture.system.domainLayer.dto.builder;

public class LeadResponseDtoBuilder {

    private String name;
    private String message;

    private LeadResponseDtoBuilder(){
    }

    public static LeadResponseDtoBuilder builder(){
        return new LeadResponseDtoBuilder();
    }

    public LeadResponseDtoBuilder name(String name){
        this.name = name;
        return this;
    }

    public LeadResponseDtoBuilder message(String message){
        this.message = message;
        return this;
    }

    public LeadResponseDto build(){
        return new LeadResponseDto(this.name, this.message);
    }


}
