package ava.task2.exception;

public class KeyNotFoundException extends RuntimeException {
    public KeyNotFoundException(String msg) {
        super(msg);
    }
}
