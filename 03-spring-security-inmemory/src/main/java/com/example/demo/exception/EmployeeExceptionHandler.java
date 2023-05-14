package com.example.demo.exception;

import com.example.demo.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleEmployeeNotFound(EmployeeNotFoundException ex){
        ExceptionResponse e = new ExceptionResponse();
        e.setMessage(ex.getMessage());
        e.setTimestamp(System.currentTimeMillis());
        e.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleEmployeeException(Exception ex){
        ExceptionResponse e = new ExceptionResponse();
        e.setMessage(ex.getMessage());
        e.setTimestamp(System.currentTimeMillis());
        e.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
    }
}
