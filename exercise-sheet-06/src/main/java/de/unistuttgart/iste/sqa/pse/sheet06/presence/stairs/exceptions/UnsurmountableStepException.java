package de.unistuttgart.iste.sqa.pse.sheet06.presence.stairs.exceptions;
/**
 * Thrown to indicate that a step of a stair could not be climbed on to.
 */
public class UnsurmountableStepException extends Exception {
	
	/**
	 * Constructs an UnsurmountableStepException with the specified detail message.
	 *
	 * @param message details about what happened.
	 */
	public UnsurmountableStepException(final String message) {
		super(message);
	}

	/**
	 * Constructs an ClimbingAbortedException with the specified detail message and cause.
	 *
	 * @param message details about the abortion.
	 * @param cause cause of this abortion.
	 */
	public UnsurmountableStepException(final String message, final Exception cause) {
		super(message, cause);
	}
}
