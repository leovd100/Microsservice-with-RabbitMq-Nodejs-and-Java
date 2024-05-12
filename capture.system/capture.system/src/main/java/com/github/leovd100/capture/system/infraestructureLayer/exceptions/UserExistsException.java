package com.github.leovd100.capture.system.infraestructureLayer.exceptions;

public class UserExistsException extends RuntimeException{
    public UserExistsException(String msg){
        super(msg);
    }
}
