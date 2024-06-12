package com.example.Task1.exception;

import com.fasterxml.jackson.core.io.JsonEOFException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice(basePackages = "com.example.Task1")
public class CustomExceptionHandler {

    @ExceptionHandler(ClientException.class)
    public ResponseEntity<?> catchClientException(ClientException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<?> catchServerException(ServerException exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
    }
}
