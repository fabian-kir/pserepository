package de.unistuttgart.iste.sqa.pse.sheet10.presence.stables;

import java.util.List;

/**
 * This class represents a veterinary who cares for the laying poultries on a regular basis
 * and specifically when one laying poultry is ill.
 *
 * @version 1.0
 */
public class Veterinary {
	private final int id;
	private final String firstName;

	private final String lastName;
	private final String phone;

	private final List<LayingPoultry> poultires;

	/**
	 * Creates a new veterinary.
	 * @param id the id of the veterinary
	 * @param firstName the first name of the veterinary
	 * @param lastName the last name of the veterinary
	 * @param phone the phone number of the veterinary
	 * @param poultires the poultries the veterinary is responsible for, must not be greater than 200
	 */
	public Veterinary(
			final int id,
			final String firstName,
			final String lastName,
			final String phone,
			final List<LayingPoultry> poultires) {
		super();

		if (poultires.size() > 200) {
			throw new IllegalArgumentException("Veterian may take care of at max 200 poultries.");
		}

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.poultires = poultires;
	}

	/**
	 * @return the last name of the veterinary
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the phone number of the veterinary
	 */
	public String getPhone() {
		return phone;
	}
}
