package de.unistuttgart.iste.sqa.pse.sheet10.presence.stables;

import java.util.Set;

/**
 * This class represents a cage in which a defined number of laying poultries can live.
 *
 * @version 1.0
 */
public class Cage<T extends LayingPoultry> {
	private final int id;
	private final boolean isFull;
	private final int capacity;
	private final int height;
	private final double width;

	private final Set<LayingPoultry> poultries;

	/**
	 * Creates a cage
	 * @param id the id of the cage
	 * @param height the height of the cage
	 * @param width the width of the cage
	 * @param capacity the capacity
	 * @param isFull true if this cage is full, false otherwise
	 * @param poultries a set containing the poultries which are in this cage, must not be greater than 200
	 */
	public Cage(
			final int id,
			final int height,
			final double width,
			final int capacity,
			final boolean isFull,
			final Set<LayingPoultry> poultries) {
		super();
		if (poultries.size() < 200) {
			throw new IllegalArgumentException("Too Many Poultries in the Stable, must be less than 200.");
		}
		this.id = id;
		this.height = height;
		this.width = width;
		this.capacity = capacity;
		this.isFull = isFull;
		this.poultries = poultries;
	}

	/**
	 * @return the id of this cage
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return true if this cage is full, false otherwise
	 */
	public boolean isFull() {
		return isFull;
	}

	/**
	 * @return a set of the poultries in this cage
	 */
	private Set<LayingPoultry> getPoultries() {
		return poultries;
	}
}
