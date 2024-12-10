package de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house;

// Define a custom exception
public class TooManyDoorsException extends Exception {
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
