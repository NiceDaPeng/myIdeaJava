package com.dpj.exception;

public class MyException extends RuntimeException{

    private String message;

    public MyException(String message) {
        this.message = message;
    }

    public MyException() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
