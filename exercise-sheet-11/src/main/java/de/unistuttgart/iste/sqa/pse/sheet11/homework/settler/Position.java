package de.unistuttgart.iste.sqa.pse.sheet11.homework.settler;

/**
 *  Position of a Settler or Resource.
 *
 *  The Position is defined by longitude and latitude, both are saved as decimal degrees.
 */
public final class Position {
	private final double longitude;
	private final double latitude;

	/**
	 *
	 * @param longitude longitude of the position, must be in [-180°, +180°]
	 * @param latitude of the position, must be in [-90°, +90°]
	 */
	public Position(final double longitude, final double latitude) {
		super();
		if (longitude < -180.0 || longitude > 180) {
			throw new IllegalArgumentException(
					"Illegal value for longitude. Value must be in [-180°, +180°] but is not.");
		}
		if (latitude < -90.0 || latitude > 90) {
			throw new IllegalArgumentException("Illegal value for latitude. Value must be in [-90°, +90°] but is not.");
		}

		this.longitude = longitude;
		this.latitude = latitude;
	}

	/**
	 * Get the longitude of the position in decimal degrees.
	 *
	 * @return longitude of the position
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Get the latitude of the position in decimal degrees.
	 *
	 * @return latitude of the position.
	 */
	public double getLatitude() {
		return latitude;
	}
}
