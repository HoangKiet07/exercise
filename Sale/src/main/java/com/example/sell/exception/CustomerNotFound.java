package com.example.sell.exception;

public class CustomerNotFound extends RuntimeException{
    private String message;

    public CustomerNotFound(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
