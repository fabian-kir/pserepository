package de.unistuttgart.iste.sqa.pse.sheet11.homework.settler;

/**
 * Position of a Settler or Resource.
 * <p>
 * The Position is defined by longitude and latitude, both are saved as decimal degrees.
 */
public record Position(double longitude, double latitude) {
	/**
	 * @param longitude longitude of the position, must be in [-180°, +180°]
	 * @param latitude  of the position, must be in [-90°, +90°]
	 */
	public Position {
		if (longitude < -180.0 || longitude > 180) {
			throw new IllegalArgumentException(
					"Illegal value for longitude. Value must be in [-180°, +180°] but is not.");
		}
		if (latitude < -90.0 || latitude > 90) {
			throw new IllegalArgumentException("Illegal value for latitude. Value must be in [-90°, +90°] but is not.");
		}

	}

	/**
	 * Get the longitude of the position in decimal degrees.
	 *
	 * @return longitude of the position
	 */
	@Override
	public double longitude() {
		return longitude;
	}

	/**
	 * Get the latitude of the position in decimal degrees.
	 *
	 * @return latitude of the position.
	 */
	@Override
	public double latitude() {
		return latitude;
	}
}
