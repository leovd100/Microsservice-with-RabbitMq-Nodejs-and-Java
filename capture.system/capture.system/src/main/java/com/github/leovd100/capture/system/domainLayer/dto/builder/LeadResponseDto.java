package com.github.leovd100.capture.system.domainLayer.dto.builder;

import lombok.Data;

import java.io.Serializable;

@Data
public class LeadResponseDto implements Serializable {

    private String name;
    private String message;

    protected LeadResponseDto(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
