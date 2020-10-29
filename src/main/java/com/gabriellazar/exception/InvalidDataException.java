package com.gabriellazar.exception;

public class InvalidDataException extends RuntimeException{

    private final String debugMessage;

    public InvalidDataException(String debugMessage) {
        this.debugMessage = debugMessage;
    }
}
