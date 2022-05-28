package com.example.ZTP_PROJ6.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler (value = {NotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(NotFoundException e) {
        ApiException apiException = new ApiException(
                e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler (value = {ForbiddenException.class})
    public ResponseEntity<Object> handleApiRequestException(ForbiddenException e) {
        ApiException apiException = new ApiException(
                e.getMessage(), HttpStatus.FORBIDDEN, ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiException, HttpStatus.FORBIDDEN);
    }
}
