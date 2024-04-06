package com.example.notification.controller;

import com.example.notification.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> internalServerException(Exception ex) {
        ErrorResponse message = new ErrorResponse(
                new Date(),
                ex.getMessage(),
                "Technical Exception : Unable to send notification");

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //TODO : Need to handle other exceptions as well like NOT_FOUND, custom exception etc
}
