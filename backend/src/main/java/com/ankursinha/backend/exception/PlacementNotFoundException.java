package com.ankursinha.backend.exception;

public class PlacementNotFoundException extends RuntimeException {
    public PlacementNotFoundException(String message) {
        super(message);
    }
}
