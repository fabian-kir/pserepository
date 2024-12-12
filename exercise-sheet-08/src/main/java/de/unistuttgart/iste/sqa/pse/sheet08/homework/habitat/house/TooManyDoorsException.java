package de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house;

/**
 *
 * Exception that should be used when more than once the .addDoor method of HouseWall is used on the same object.
 */
public class TooManyDoorsException extends IllegalArgumentException {
    // Default constructor
    public TooManyDoorsException() {
        super();
    }

    // Constructor that accepts a message
    public TooManyDoorsException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause
    public TooManyDoorsException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public TooManyDoorsException(Throwable cause) {
        super(cause);
    }
}
