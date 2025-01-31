package de.unistuttgart.iste.sqa.pse.sheet12.homework.hamsterclub;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

/**
 * A club of hamsters.
 */
public final class HamsterClub implements Club {

	private final List<ClubMember> members;

	/**
	 * Create a new {@code HamsterClub}.
	 *
	 * @param members members of the club. Must not be null or empty.
	 * @throws IllegalArgumentException if members is null or empty
	 */
	public HamsterClub(final List<ClubMember> members) throws IllegalArgumentException {
		if (members == null || members.isEmpty()) {
			throw new IllegalArgumentException("List of ClubMembers is null or empty but must not be.");
		}
		this.members = members;
	}

	@Override
	public List<ClubMember> getMembersWithUnpaidFees() {
		return members.stream().filter((member) -> !member.getHasPaidContributions()).toList();
    }

	@Override
	public List<String> getNameOfMembers() {
		return members.stream().map(ClubMember::getName).sorted().toList();
	}

	@Override
	public double getTotalContributions() {
		return members.stream().mapToDouble(member -> member.getContributions()).sum();
	}

	@Override
	public void applyDiscount() {
		members.stream().filter(member -> member.getAge() >= 60).forEach(member -> {
			member.setContributions(member.getContributions()*.9);
		});
	}

	@Override
	public ClubMember getOldestMember() {
		if (members.isEmpty()) {
			throw new NoSuchElementException("Der Club hat keine Member");
		}
		return members.stream().sorted(
				(member1, member2) -> {
					if (member1.getAge() == member2.getAge()) {
						return member2.getName().compareTo(member1.getName());
					}
					return member2.getAge() - member1.getAge();
				}
		).reduce((member1, member2) -> member1).get();

		return members.stream().sorted(Comparator.comparing(ClubMember::getName).reversed()).max(Comparator.comparing(ClubMember::getAge)).get();
	}

	@Override
	public List<ClubMember> getMembers() {
		return members;
	}
}
