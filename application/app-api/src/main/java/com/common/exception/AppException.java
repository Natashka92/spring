package com.common.exception;


public class AppException extends RuntimeException{

    private  String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
