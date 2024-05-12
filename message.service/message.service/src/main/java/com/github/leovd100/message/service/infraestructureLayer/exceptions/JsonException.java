package com.github.leovd100.message.service.infraestructureLayer.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonException extends RuntimeException {

    public JsonException(String msg) {
        super(msg);
    }
}
