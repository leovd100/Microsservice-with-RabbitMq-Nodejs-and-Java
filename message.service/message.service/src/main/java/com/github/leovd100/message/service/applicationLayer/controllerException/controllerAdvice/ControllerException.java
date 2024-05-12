package com.github.leovd100.message.service.applicationLayer.controllerException.controllerAdvice;

import com.github.leovd100.message.service.infraestructureLayer.exceptions.JsonException;
import com.github.leovd100.message.service.infraestructureLayer.exceptions.RabbitAMQPException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {
    Logger logger = LogManager.getLogger(ControllerException.class);
    @ExceptionHandler(RabbitAMQPException.class)
    public ResponseEntity<String> feingException(RabbitAMQPException exception) {
       return generateBodyResponseEntityExceptionHandler(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JsonException.class)
    public ResponseEntity<String> jsonException(JsonException exception) {
       return generateBodyResponseEntityExceptionHandler(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> dataIntegrityViolationException(DataIntegrityViolationException exception) {
        return generateBodyResponseEntityExceptionHandler(exception, HttpStatus.CONFLICT);
    }


    private ResponseEntity<String> generateBodyResponseEntityExceptionHandler(RuntimeException exception, HttpStatus httpStatus){
        HttpStatus status = httpStatus;
        logger.fatal("%d %s %s".formatted(status.value(), status.toString(), exception.getMessage()));
        return ResponseEntity.status(status).body(exception.getMessage());
    }

}
