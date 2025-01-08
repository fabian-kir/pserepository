package de.unistuttgart.iste.sqa.pse.sheet10.presence.stables;

import java.util.Optional;

/**
 * This class represents a laying poultry which can be bred in the stable.
 *
 * @version 1.0
 */
public class LayingPoultry {
	private final int id;
	private final String type;
	private final double age;
	private final double weight;

	private final Optional<Veterinary> veterinary;

	/**
	 * Creates a new laying poultry.
	 * @param id the id of the laying poultry
	 * @param type the type of the laying poultry
	 * @param age the age of the laying poultry
	 * @param weight the weight of the laying poultry
	 * @param veterinary an optional veterinary which cares for the laying poultry
	 */
	public LayingPoultry(
			final int id,
			final String type,
			final double age,
			final double weight,
			final Optional<Veterinary> veterinary) {
		super();
		this.id = id;
		this.type = type;
		this.age = age;
		this.weight = weight;
		this.veterinary = veterinary;
	}

	/**
	 * @return the weight of the laying poultry
	 */
	public double getWeight() {
		return weight;
	}
}
