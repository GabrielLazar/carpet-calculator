package com.gabriellazar.exception;

public class DataNotFoundException extends RuntimeException{

    private final String debugMessage;

    public DataNotFoundException(String debugMessage) {
        this.debugMessage = debugMessage;
    }
}
