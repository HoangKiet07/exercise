package com.example.sell.exception;

public class CustomerExits extends RuntimeException{
    private String message;

    public CustomerExits(String message){
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
