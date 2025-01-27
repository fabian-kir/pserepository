package de.unistuttgart.iste.sqa.pse.sheet12.homework.hamsterclub;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Club Interface providing methods to process a list of {@link ClubMember}.
 */
public interface Club {

	/**
	 * Maps the names of all members to a new list of alphabetically sorted Strings.
	 *
	 * @return an alphabetically sorted list of the names of all members
	 */
	public List<String> getNameOfMembers();

	/**
	 * Totals the amount of contributions this club can expect.
	 *
	 * @return the sum of total contributions across all members
	 */
	public double getTotalContributions();

	/**
	 * Applies a discount to all members above a certain age.
	 *
	 * Calling this method multiple times will provide a stacking discount. Ensures,
	 * that the contributions of all members above the specified age was reduced by
	 * a specific amount.
	 */
	public void applyDiscount();

	/**
	 * Filters the list of members for those that have not payed their
	 * membership-fees yet.
	 *
	 * @return list of all members with unpaid fees
	 */
	public List<ClubMember> getMembersWithUnpaidFees();

	/**
	 * Searches the List of members for the oldest individual, alphabetical order
	 * acts as a tie-breaker.
	 *
	 * If two or more members share the highest age value,the member with the
	 * alphabetically latter name is returned. E.g. if Siegbert and Tadeus share the
	 * highest age, Tadeus will be considered the oldest member due to his name.
	 *
	 * Requires at least one member in the club, otherwise a {@link NoSuchElementException} is thrown.
	 *
	 * @throws NoSuchElementException if there is no (oldest) member
	 * @return oldest member of this club, i
	 */
	public ClubMember getOldestMember();

	/**
	 * Getter method for the member field.
	 *
	 * @return a list containing the members of this club
	 */
	public List<ClubMember> getMembers();
}
