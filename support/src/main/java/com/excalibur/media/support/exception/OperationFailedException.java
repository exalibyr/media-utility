package com.excalibur.media.support.exception;

public class OperationFailedException extends RuntimeException {
    public OperationFailedException(String message) {
        super(message);
    }

    public OperationFailedException() {
    }
}
