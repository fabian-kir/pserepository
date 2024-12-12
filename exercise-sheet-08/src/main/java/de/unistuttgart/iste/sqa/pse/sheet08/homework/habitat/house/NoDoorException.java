package de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house;

/**
 * Exception that should be used when the .getDoors method of HouseWall is used, when there's not been added a door to the wall.
 */
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
