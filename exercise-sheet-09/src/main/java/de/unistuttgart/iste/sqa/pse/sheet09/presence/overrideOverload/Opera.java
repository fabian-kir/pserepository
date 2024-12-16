package de.unistuttgart.iste.sqa.pse.sheet09.presence.overrideOverload;

/**
 * A class for an opera.
 */
public class Opera extends Building {

	private static final String OPERA_LITERAL_NLS = "Opera";

	/**
	 * Constructor for the class.
	 *
	 * @param name the name of the opera
	 */
	public Opera(final String name) {
		super(name);
	}

	@Override
	protected String getBuildingType() {
		return OPERA_LITERAL_NLS;
	}
}
