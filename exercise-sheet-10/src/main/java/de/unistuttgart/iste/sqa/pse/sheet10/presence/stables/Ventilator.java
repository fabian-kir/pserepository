package de.unistuttgart.iste.sqa.pse.sheet10.presence.stables;

import java.util.Date;

/**
 * This class represents a ventilator which should be opened independent of the
 * current temperature.
 *
 * @version 1.0
 */
public class Ventilator {
	private final int id;
	private boolean on;
	private final int width;
	private final Date purchaseDate;
	private final int height;

	/**
	 * Creates a new ventilator.
	 * @param id the id of the ventilator
	 * @param width the width of the ventilator
	 * @param height the height of the ventilator
	 * @param on true if the ventilator is on, false otherwise
	 * @param purchaseDate the purchase date of the ventilator
	 */
	public Ventilator(final int id, final int width, final int height, final boolean on, final Date purchaseDate) {
		super();
		this.id = id;
		this.width = width;
		this.height = height;
		this.on = on;
		this.purchaseDate = purchaseDate;
	}

	/**
	 * Turns the ventilator on.
	 * Ensures that the ventilator is turned on.
	 */
	void turnOn() {
		this.on = true;
	}

	/**
	 * Turns the ventilator off.
	 * Ensures that the ventilator is turned off.
	 */
	protected void turnOff() {
		this.on = false;
	}

	/**
	 * @return true if the ventilator is on, false otherwise
	 */
	protected boolean isOn() {
		return this.on;
	}

	/**
	 * @return the id of the ventilator
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the purchase date of the ventilator
	 */
	public Date getPurchaseDate() {
		return purchaseDate;
	}
}
