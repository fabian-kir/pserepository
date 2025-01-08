package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.Identifier;

/**
 * Represents an individual stationary item in the warehouse system.
 */
public abstract class StationeryItem {
	// classinvariant: identification != null;

	private final Identifier identifier;
	private final String descriptor;

	/**
	 * Creates a new item with the given identification.
	 *
	 * @param identifier Identification of the item. Must not be null.
	 * @param descriptor Descriptor of the item. Must not be null.
	 *
	 * @throws IllegalArgumentException if any of identifier or descriptor is null.
	 */
	public StationeryItem(final Identifier identifier, final String descriptor) {
		if (identifier == null || descriptor == null) {
			throw new IllegalArgumentException("A stationary item's identifier or descriptor must not be null.");
		}
		this.identifier = identifier;
		this.descriptor = descriptor;
	}

	/**
	 * Get the identification object of this item.
	 *
	 * @return The identification object of this item.
	 */
	public Identifier getIdentifier() {
		return identifier;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " (" + descriptor + ")";
	}
}
