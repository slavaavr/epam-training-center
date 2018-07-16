package ava.java_school.java_se_05.task1.exception;

public class CantCreateFileException extends RuntimeException {
    public CantCreateFileException(String message) {
        super(message);
    }

}
