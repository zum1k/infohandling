package com.epam.training.infohandling.exception;

public class TextActionException extends Throwable {
    public TextActionException(String message) {
        super(message);
    }

    public TextActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextActionException(Throwable cause) {
        super(cause);
    }
}
