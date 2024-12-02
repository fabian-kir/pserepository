package de.unistuttgart.iste.sqa.pse.sheet07.homework.exceptions;

import de.hamstersimulator.objectsfirst.exceptions.HamsterException;

/**
 *
 * Exception used when hamster is stuck and therefore is unable to move
 *
 */
public class NoWayToGoException extends HamsterException {

	private static final long serialVersionUID = -1850656605851478458L;

	public NoWayToGoException() {
		super("Hamster is locked in a single cell");
	}
}
