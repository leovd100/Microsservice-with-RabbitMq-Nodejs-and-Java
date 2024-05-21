package com.github.leovd100.capture.system.domainLayer.dto.builder;

import lombok.Data;

import java.io.Serializable;

public record LeadResponseDto(String name, String message) implements Serializable {

    @Override
    public String toString() {
        return "LeadResponseDto{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
