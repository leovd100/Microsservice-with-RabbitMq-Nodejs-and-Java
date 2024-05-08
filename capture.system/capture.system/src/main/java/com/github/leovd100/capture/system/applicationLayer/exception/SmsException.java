package com.github.leovd100.capture.system.applicationLayer.exception;

import com.fasterxml.jackson.core.JsonProcessingException;

public class SmsException extends JsonProcessingException {
    public SmsException(String msg) {
        super(msg);
    }
}
