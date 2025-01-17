package com.carlos.workshopMongo.controller.exception;

import com.carlos.workshopMongo.service.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        HttpStatus stats = HttpStatus.NOT_FOUND;
        StandartError err = new StandartError(System.currentTimeMillis(), stats.value(), "Não encontrado", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(stats).body(err);
    }
}
