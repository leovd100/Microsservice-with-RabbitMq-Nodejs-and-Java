package com.github.leovd100.capture.system.infraestructureLayer.exceptions;

import jakarta.persistence.PersistenceException;

public class DataBaseException extends PersistenceException {
    public DataBaseException(String message){
        super(message);
    }
}
