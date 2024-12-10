package de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house;

public class NoDoorException extends Exception {
    // Default constructor
    public NoDoorException() {
        super();
    }

    // Constructor that accepts a message
    public NoDoorException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause
    public NoDoorException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public NoDoorException(Throwable cause) {
        super(cause);
    }}
