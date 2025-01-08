package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.Identifier;

/**
 * Represents a compass in a warehouse system.
 *
 * A compass is a stationery item for drawing circles.
 */
public final class Compass extends StationeryItem {

	/**
	 * Create a new compass with the given identifier and descriptor.
	 *
	 * @param identifier Identification of the compass. Must not be null.
	 * @param descriptor Descriptor of the compass. Must not be null.
	 */
	public Compass(final Identifier identification, final String descriptor) {
		super(identification, descriptor);
	}
}
