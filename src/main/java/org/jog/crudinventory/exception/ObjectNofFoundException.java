package org.jog.crudinventory.exception;

public class ObjectNofFoundException extends RuntimeException {
    public ObjectNofFoundException() {
    }

    public ObjectNofFoundException(String message) {
        super(message);
    }

    public ObjectNofFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
