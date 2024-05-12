package com.github.leovd100.capture.system.infraestructureLayer.exceptions;

import com.github.leovd100.capture.system.domainLayer.entities.Lead;

public class RequestException extends RuntimeException {
    public RequestException(String message){

        super(message);
    }

}
