package de.unistuttgart.iste.sqa.pse.sheet09.presence.overrideOverload;

/**
 * Abstract class for a building
 *
 */
public abstract class Building {

	private final String name;

	/**
	 * Constructor for the class
	 * @param name the name of the building
	 */
	public Building(final String name) {
		this.name = name;
	}

	/**
	 * Prints type and name of the building to the console
	 */
	public void printBuildingInfo() {
		System.out.format("My type is %s\n", getBuildingType());
		System.out.format("My name is %s\n", name);
	}

	/**
	 * @return the type of the building
	 */
	protected abstract String getBuildingType();

	/**
	 * @return the name of the building
	 */
	public String getBuildingName() {
		return name;
	}
}
