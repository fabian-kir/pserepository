package de.unistuttgart.iste.sqa.pse.sheet10.presence.stables;

import java.util.Set;

/**
 * This class represents a technician who requests maintenance for the stable.
 *
 * @version 1.0
 */
public class Technician {
	private final int id;
	private final String firstName;
	private final String lastName;
	private final String phone;

	private final Set<Stable> cages;

	/**
	 * Creates a new technician.
	 * @param id the id of the technician
	 * @param firstName the first name of the technician
	 * @param lastName the last name of the technician
	 * @param phone the phone number of the technician
	 * @param stables the stables the technician is responsible for
	 */
	public Technician(
			final int id,
			final String firstName,
			final String lastName,
			final String phone,
			final Set<Stable> stables) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.cages = stables;
	}

	/**
	 * Requests maintenance for a stable.
	 * @param stable the stable for which maintenance is requested
	 */
	protected void maintenanceRequest(final Stable stable) {}

	/**
	 * @return the phone number of the technician
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the stables the technician is responsible for
	 */
	public Set<Stable> getStables() {
		return cages;
	}
}
