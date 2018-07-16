package ava.java_se_05.task2.exception;

public class KeyNotFoundException extends RuntimeException {
    public KeyNotFoundException(String msg) {
        super(msg);
    }
}
