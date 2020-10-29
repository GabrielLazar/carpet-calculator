package com.gabriellazar.exception;

public class InvalidDataException extends RuntimeException{

    private final String debugMessage;

    public InvalidDataException(String debugMessage) {
        super(debugMessage);
        this.debugMessage = debugMessage;
    }
}
