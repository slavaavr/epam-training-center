package ava.java_school.java_se_05.task1.exception;

public class PathNotExistException extends RuntimeException {

    public PathNotExistException() {
        super("The specified path does not exist!");
    }

    public PathNotExistException(String path) {
        super(String.format("Cannot find path '%s' because it does not exist!", path));
    }
}
