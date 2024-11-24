package de.unistuttgart.iste.sqa.pse.sheet06.presence.stairs.exceptions;

/**
 * Thrown to indicate that an attempt to climb some stairs was aborted.
 */
public class ClimbingAbortedException extends RuntimeException {

	/**
	 * Constructs an ClimbingAbortedException with the specified detail message.
	 *
	 * @param message details about the abortion.
	 */
	public ClimbingAbortedException(final String message) {
		super(message);
	}

	/**
	 * Constructs an ClimbingAbortedException with the specified detail message and cause.
	 *
	 * @param message details about the abortion.
	 * @param cause cause of this abortion.
	 */
	public ClimbingAbortedException(final String message, final Exception cause) {
		super(message, cause);
	}
}
