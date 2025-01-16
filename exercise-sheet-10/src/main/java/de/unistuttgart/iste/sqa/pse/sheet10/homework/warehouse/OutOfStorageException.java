package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

/**
 * Exception thrown when trying to add an item to a fully occupied storage rack.
 */
public class OutOfStorageException extends Exception {
    /**
     * Constructs an OutOfStorageException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public OutOfStorageException(String message) {
        super(message);
    }

    /**
     * Constructs an OutOfStorageException with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     * @param cause the cause (which is saved for later retrieval by the getCause() method).
     */
    public OutOfStorageException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs an OutOfStorageException with the specified cause and a detail message of
     *
     * @param cause the cause (which is saved for later retrieval by the getCause() method).
     */
    public OutOfStorageException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs an OutOfStorageException with no detail message.
     */
    public OutOfStorageException() {
        super();
    }
}
