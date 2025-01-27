package de.unistuttgart.iste.sqa.pse.sheet12.homework.hamsterclub;

/**
 * This class models an individual member of a {@link Club}.
 * @see de.unistuttgart.iste.sqa.pse.sheet12.homework.hamsterclub.Club
 */
public final class ClubMember implements Comparable<ClubMember> {

	private final String name;
	private final int age;
	private double contributions;
	private boolean hasPaidFees;

	/**
	 * Constructs of a new club member.
	 *
	 * @param name name of the new member. Must not be {@code null}.
	 * @param age age of the new member. Must be >= 0.
	 * @param contributions contributions of the new member. Must be >= 0.
	 * @param hasPaidFees payment status of the new member's fees
	 * @throws IllegalArgumentException if name is {@code null} or the any of age and contributions is negative.
	 */
	public ClubMember(final String name, final int age, final double contributions, final boolean hasPaidFees)
			throws IllegalArgumentException {
		if (name == null || age < 0 || contributions < 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.age = age;
		this.contributions = contributions;
		this.hasPaidFees = hasPaidFees;
	}

	/**
	 * Checks if the specified object equals the club member on which it is called.
	 */
	@Override
	public boolean equals(final Object object) {

		if (object == this) {
			return true;
		}

		if (!(object instanceof ClubMember)) {
			return false;
		}

		ClubMember member = (ClubMember) object;

		return member.getName().equals(name)
				&& member.getAge() == age
				&& member.getContributions() == contributions
				&& member.getHasPaidContributions() == hasPaidFees;
	}

	/**
	 * Overridden compareTo method for use with clubMemberComparator. It compares members based on their age.
	 */
	@Override
	public int compareTo(final ClubMember otherMember) {
		return this.age - otherMember.getAge();
	}

	/**
	 * Get the name of the member.
	 *
	 * @return the member's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the age of the member.
	 *
	 * @return the member's age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Get the contributions of the member.
	 *
	 * @return the member's contributions.
	 */
	public double getContributions() {
		return contributions;
	}

	/**
	 * Update the contributions of the member.
	 *
	 * @param contributions, the new contributions, must be >= 0.
	 */
	public void setContributions(final double contributions) {
		if (contributions < 0) {
			throw new IllegalArgumentException();
		}
		this.contributions = contributions;
	}

	/**
	 * Get the payment status of the member.
	 *
	 * @return true, if the member paid their contributions, false otherwise.
	 */
	public boolean getHasPaidContributions() {
		return hasPaidFees;
	}

	/**
	 * Update the payment status of the member.
	 *
	 * @param hasPaidFees, the new payment status.
	 */
	public void setHasPaidContributions(final boolean hasPaidFees) {
		this.hasPaidFees = hasPaidFees;
	}

	@Override
	public String toString() {
		return "ClubMember[name=" + this.name + ", age=" + this.age + ", contributions=" + this.contributions
				+ ", hasPaidFees=" + this.hasPaidFees + "]";
	}
}
