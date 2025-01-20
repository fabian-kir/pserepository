package de.unistuttgart.iste.sqa.pse.sheet11.homework.settler;

/**
 * Type of a Resource
 */
public final class ResourceType {
	private final String label;

	/**
	 * Create a new instance of {@link ResourceType}
	 *
	 * @param label label of the type. Must not be {@code null} or blank.
	 */
	public ResourceType(final String label) {
		super();
		if (label == null || label.isBlank()) {
			throw new IllegalArgumentException("The resource type's label must be neither null nor blank, but is.");
		}
		this.label = label;
	}

	/**
	 * Get the label of the resource type.
	 *
	 * @return label of the resource type.
	 */
	public String getLabel() {
		return label;
	}
}
