package ava.task1.exception;

public class PathNotExistException extends RuntimeException {

    public PathNotExistException() {
        super("The specified path does not exist!");
    }

    public PathNotExistException(String message) {
        super(message);
    }
}
