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

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handlerBusinessException (BusinessException businessException, WebRequest webRequest){
        return new ResponseEntity<Object>(new ApiError(businessException.getMessage(), businessException.getHttpStatus().toString(), LocalDateTime.now()), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerException (Exception exception, WebRequest webRequest){
        return new ResponseEntity<Object>(new ApiError(exception.getMessage(), "400", LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }
}
