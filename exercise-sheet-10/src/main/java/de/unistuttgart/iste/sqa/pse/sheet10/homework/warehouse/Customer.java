package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

/**
 * Represents a customer who can order items.
 */
public final class Customer {
	// classinvariant:
	// name != null and name is not blank.

	private final String name;

	/**
	 * Creates a new customer with the given name.
	 *
	 * @param name Name of the customer. Must not be null or blank.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public Customer(final String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Customers may not have null or empty names.");
		}
		this.name = name;
	}

	/**
	 * Get the customer's name.
	 *
	 * @return This customer's name.
	 */
	public String getName() {
		return name;
	}
}
