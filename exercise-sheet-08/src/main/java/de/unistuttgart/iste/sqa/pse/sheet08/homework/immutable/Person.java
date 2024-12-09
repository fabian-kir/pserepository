package de.unistuttgart.iste.sqa.pse.sheet08.homework.immutable;

import java.util.Date;

/**
 * Represents a person with a name and birthdate.
 *
 * Name and birthdate must not be {@code null} and the name must not be blank.
 *
 * @author Mika Hepper, Fabian Kirschenmann
 */
// public class Person { // Klasse nicht final, Vererbung möglich
public final class Person {

	public String name;
	//public Date birthDate; // final fehlt, birthDate kann neu zugewiesen werden.
	public final Date birthDate;
	/**
	 * Creates a new person with the given name and birthdate.
	 *
	 * @param name      Name of the person. Must not be {@code null} or blank.
	 * @param birthDate Birth date of the person. Must not be {@code null}.
	 */
	// public Person(final String name, final Date birthDate) { // throws IllegalArgumentException, ist eine RuntimeException, aber dennoch besserer Stil es zu erwähnen
	public Person(final String name, final Date birthDate) throws IllegalArgumentException {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("A person must not have a null or blank name");
		}
		if (birthDate == null) {
			throw new IllegalArgumentException("A person's birth date must not be null.");
		}
		this.name = name;

		// this.birthDate = birthDate; //deepCopy fehlt, also wäre der Klassenzustand von aussen veränderlich, besser:
		this.birthDate = new Date(birthDate.getDate());
	}

	/**
	 * @return This person's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return This person's birth date.
	 */
	public Date getBirthDate() {

		// return birthDate; // birthDate können vom Benutzer verwendet und somit verändert werden, wodurch der Nutzer den Klassenzustand ungewollt verändern könnte.
		// Durch new Date wird ein neues Objekt der Klasse Date erstellt, welchem der gleiche Wert wie birthDate zugewiesen wird. Dadurch ist "new Date" eine andere Referenz und
		// falls diese Verändert wird, verändert sich birthDate nicht.
		return new Date(this.birthDate.getDate());
	}


	/**
	 * Sets this person's name.
	 *
	 * @param name The new name. Must not be {@code null} or blank.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	/* Setter dürfen nicht existieren für unveränderliche Objekte
	public void setName(final String name) throws IllegalArgumentException {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("A person must not have a null or blank name.");
		}
		this.name = name;
	}
	*/



	/**
	 * Sets this person's birth date.
	 *
	 * @param birthDate The new birth date. Must not be {@code null}.
	 * @throws IllegalArgumentException If the precondition is not satisfied.
	 */
	/* Setter dürfen nicht existieren für unveränderliche Objekte
	public void setBirthDate(final Date birthDate) throws IllegalArgumentException {
		if (birthDate == null) {
			throw new IllegalArgumentException("A person's birth date must not be null.");
		}
		this.birthDate = birthDate;
	}
	*/
}
