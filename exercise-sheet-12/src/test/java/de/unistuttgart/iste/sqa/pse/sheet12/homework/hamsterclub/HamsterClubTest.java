package de.unistuttgart.iste.sqa.pse.sheet12.homework.hamsterclub;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public final class HamsterClubTest {

	private Club club;

	@BeforeEach
	public void setUp() {
		final ArrayList<ClubMember> members = new ArrayList<>();

		ClubMember c = new ClubMember("c", 10, 7.0, false);
		members.add(c);
		ClubMember b = new ClubMember("b", 23, 30.0, true);
		members.add(b);
		ClubMember a = new ClubMember("a", 90, 10.0, true);
		members.add(a);
		ClubMember e = new ClubMember("e", 80, 50.0, false);
		members.add(e);
		ClubMember d = new ClubMember("d", 40, 40.0, true);
		members.add(d);
		ClubMember f = new ClubMember("f", 55, 100.0, false);
		members.add(f);
		ClubMember g = new ClubMember("g", 90, 14.0, true);
		members.add(g);

		this.club = new HamsterClub(members);
	}

	@Test
	public void testGetNameOfMembers() {
		final ArrayList<String> expected = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g"));
		assertEquals(expected, club.getNameOfMembers());
	}

	@Test
	public void testGetTotalContributions() {
		final double expected = 251.0;
		final double epsilon = 0.0001;
		assertEquals(expected, club.getTotalContributions(), epsilon);
	}

	@Test
	public void testApplyDiscount() {
		final ArrayList<ClubMember> list = new ArrayList<>(club.getMembers());

		final List<Double> expected = Arrays.asList(
				list.get(0).getContributions(),
				list.get(1).getContributions(),
				list.get(2).getContributions() * 9 / 10,
				list.get(3).getContributions() * 9 / 10,
				list.get(4).getContributions(),
				list.get(5).getContributions(),
				list.get(6).getContributions() * 9 / 10);

		club.applyDiscount();

		final List<Double> actual = Arrays.asList(
				list.get(0).getContributions(),
				list.get(1).getContributions(),
				list.get(2).getContributions(),
				list.get(3).getContributions(),
				list.get(4).getContributions(),
				list.get(5).getContributions(),
				list.get(6).getContributions());

		assertEquals(expected, actual);
	}

	@Test
	public void testGetMembersWithUnpaidFees() {
		final ArrayList<ClubMember> expected = new ArrayList<>();
		expected.add(club.getMembers().get(0));
		expected.add(club.getMembers().get(3));
		expected.add(club.getMembers().get(5));
		assertEquals(expected, club.getMembersWithUnpaidFees());
	}

	@Test
	public void testGetOldestMember() {
		final ClubMember expected = club.getMembers().get(6);
		assertEquals(expected, club.getOldestMember());
	}
}
