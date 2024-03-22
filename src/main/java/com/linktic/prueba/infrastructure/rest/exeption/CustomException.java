package com.linktic.prueba.infrastructure.rest.exeption;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
