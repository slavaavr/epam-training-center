package ava.java_se_05.task2.exception;

public class PropertyFileNotFoundException extends RuntimeException {
    public PropertyFileNotFoundException(String msg) {
        super(msg);
    }
}
