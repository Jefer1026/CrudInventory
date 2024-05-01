package org.jog.crudinventory.exception;

public class ObjectRepeatedException extends RuntimeException{

    public ObjectRepeatedException() {
    }

    public ObjectRepeatedException(String message) {
        super(message);
    }

    public ObjectRepeatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
