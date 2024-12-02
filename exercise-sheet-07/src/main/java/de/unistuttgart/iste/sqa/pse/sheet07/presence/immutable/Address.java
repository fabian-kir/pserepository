package de.unistuttgart.iste.sqa.pse.sheet07.presence.immutable;

/**
 * Class representing an address, do NOT modify!
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Address {
	private String streetName;
	private int streetNumber;
	private String postalCode;
	private String cityName;

	/**
	 * Create a new instance of {@link Address}.
	 *
	 * @param streetName Must not be {@code null} or blank
	 * @param streetNumber Must be greater than 0.
	 * @param postalCode Must not be {@code null} or blank
	 * @param cityName Must not be {@code null} or blank
	 */
	public Address(final String streetName, final int streetNumber, final String postalCode, final String cityName) {
		if (streetName == null
				|| streetName.isBlank()
				|| streetNumber <= 0
				|| postalCode == null
				|| postalCode.isBlank()
				|| cityName == null
				|| cityName.isBlank()) {
			throw new IllegalArgumentException("One of the given arguments violates the preconditions.");
		}
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
		this.cityName = cityName;
	}

	/**
	 *
	 * @return street name of the address
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 *
	 * @param streetName Must not be {@code null} or blank.
	 */
	public void setStreetName(final String streetName) {
		if (streetName == null || streetName.isBlank()) {
			throw new IllegalArgumentException("Postalcode is null, but must not be.");
		}
		this.streetName = streetName;
	}

	/**
	 *
	 * @return street number of the address
	 */
	public int getStreetNumber() {
		return streetNumber;
	}

	/**
	 *
	 * @param streetNumber Must be greater than 0.
	 */
	public void setStreetNumber(final int streetNumber) {
		if (streetNumber <= 0) {
			throw new IllegalArgumentException("Street number is less than or equal to zero, but must not be.");
		}
		this.streetNumber = streetNumber;
	}

	/**
	 *
	 * @return postal code of the address.
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 *
	 * @param postalCode Must not be {@code null} or blank.
	 */
	public void setPostalCode(final String postalCode) {
		if (postalCode == null || postalCode.isBlank()) {
			throw new IllegalArgumentException("Postal code is null, but must not be.");
		}
		this.postalCode = postalCode;
	}

	/**
	 *
	 * @return city name of the address
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 *
	 * @param cityName Must not be {@code null} or blank.
	 */
	public void setCityName(final String cityName) {
		if (cityName == null || cityName.isBlank()) {
			throw new IllegalArgumentException("City name is null, but must not be.");
		}
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "Address [street name=" + streetName + ", street number=" + streetNumber + ", postal code=" + postalCode
				+ ", city name=" + cityName + "]";
	}
}
