package com.github.leovd100.message.service.applicationLayer.controllerException.controllerAdvice;

import com.github.leovd100.message.service.infraestructureLayer.exceptions.RabbitAMQPException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {
    Logger logger = LogManager.getLogger(ControllerException.class);
    @ExceptionHandler(RabbitAMQPException.class)
    public ResponseEntity<String> feingException(RabbitAMQPException e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        logger.fatal("%d %s %s".formatted(status.value(), status.toString(), e.getMessage()));
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
