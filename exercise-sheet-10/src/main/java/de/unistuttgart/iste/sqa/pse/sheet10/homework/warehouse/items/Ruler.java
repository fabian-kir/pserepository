package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.Identifier;

/**
 * Represents a ruler in the warehouse system.
 *
 * A Ruler is an elongates piece of plastic or wood with a scale on it.
 */
public final class Ruler extends StationeryItem {

	/**
	 * Create a new ruler with the given identifier and descriptor.
	 *
	 * @param identifier Identification of the ruler. Must not be null.
	 * @param descriptor Descriptor of the ruler. Must not be null.
	 */
	public Ruler(final Identifier identifier, final String descriptor) {
		super(identifier, descriptor);
	}
}
