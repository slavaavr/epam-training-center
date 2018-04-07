package ava.task1.exception;

public class CantCreateFileException extends RuntimeException {
    public CantCreateFileException(String message) {
        super(message);
    }

}
