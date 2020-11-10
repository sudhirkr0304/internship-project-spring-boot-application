package com.example.internshipproject.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex , WebRequest request) {

        ErrorResponse errorResponse =
                new ErrorResponse(new Date() , HttpStatus.NOT_FOUND.toString(), request.getDescription(false),ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalResponseHandler(Exception ex , WebRequest request) {

        ErrorResponse errorResponse =
                new ErrorResponse(new Date() , HttpStatus.INTERNAL_SERVER_ERROR.toString(), request.getDescription(false),ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
