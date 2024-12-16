package de.unistuttgart.iste.sqa.pse.sheet09.presence.overrideOverload;

/**
 * A class for a library.
 */
public class Library extends Building {

	private static final String LIBRARY_LITERAL_NLS = "Library";

	/**
	 * Constructor for the class.
	 *
	 * @param name the name of the library
	 */
	public Library(final String name) {
		super(name);
	}

	@Override
	protected String getBuildingType() {
		return LIBRARY_LITERAL_NLS;
	}
}
