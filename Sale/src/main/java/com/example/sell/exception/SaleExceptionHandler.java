package com.example.sell.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class SaleExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<Object> handlerCustomerNotFound (CustomerNotFound customerNotFound, WebRequest webRequest){
        return new ResponseEntity<Object>(new ApiError(customerNotFound.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerExits.class)
    public ResponseEntity<Object> handlerCustomerExits (CustomerExits customerExits, WebRequest webRequest){
        return new ResponseEntity<Object>(new ApiError(customerExits.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }
}
