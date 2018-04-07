package ava.task1.exception;

public class CantClimbToCatalogAboveException extends RuntimeException {
    public CantClimbToCatalogAboveException() {
        super("Can't climb to catalog above, because it is a root catalog!");
    }

    public CantClimbToCatalogAboveException(String message) {
        super(message);
    }
}
