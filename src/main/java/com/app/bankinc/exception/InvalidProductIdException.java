package com.app.bankinc.exception;

public class InvalidProductIdException extends RuntimeException {
    public InvalidProductIdException(String message) {
        super(message);
    }
}
