package de.unistuttgart.iste.sqa.pse.sheet10.presence.stables;

import java.util.List;

/**
 * This class represents a barn, which consists of fans and cages. In this stable
 * laying poultries can be bred.
 *
 * @version 1.0
 */
public class Stable {
	private final int id;
	protected final String addressOfStable;
	protected final float temperature;
	private final int capacity;
	private final double surface;

	private final List<Ventilator> ventilators;
	private final List<Cage> cages;
	private final Technician technician;

	/**
	 * Creates a new stable.
	 * @param id the id of the stable
	 * @param address the address of the stable
	 * @param surface the surface of the stable
	 * @param technician the technician who is responsible for the stable
	 * @param temperature the temperature of the stable
	 * @param capacity the capacity of the stable
	 * @param cages the cages in the stable, must not be less than 10
	 * @param ventilators the ventilators in the stable
	 */
	public Stable(
			final int id,
			final String address,
			final double surface,
			final Technician technician,
			final float temperature,
			final int capacity,
			final List<Cage> cages,
			final List<Ventilator> ventilators) {
		if (cages.size() < 10) {
			throw new IllegalArgumentException("To few cages, must be at least 10");
		}

		this.id = id;
		this.addressOfStable = address;
		this.surface = surface;
		this.technician = technician;
		this.temperature = temperature;
		this.capacity = capacity;

		this.cages = cages;
		this.ventilators = ventilators;
	}

	/**
	 * Checks the temperature of the stable and turns on or off the ventilators accordingly.
	 * Ensures that the ventilators are turned off if the temperature is above 40 degrees.
	 * Ensures that the ventilators are turned on if the temperature is below or equal to 40 degrees.
	 */
	public void checkTemperature() {
		if (temperature > 40) {
			turnOffAllVentilators();
		} else {
			turnOnAllVentilators();
		}
	}

	/**
	 * Turns on all ventilators in the stable.
	 * Ensures that all ventilators are turned on.
	 */
	private void turnOnAllVentilators() {
		for (final Ventilator aVentilator : ventilators) {
			aVentilator.turnOn();
		}
	}

	/**
	 * Turns off all ventilators in the stable.
	 * Ensures that all ventilators are turned off.
	 */
	private void turnOffAllVentilators() {
		for (final Ventilator aVentilator : ventilators) {
			aVentilator.turnOff();
		}
	}
}
