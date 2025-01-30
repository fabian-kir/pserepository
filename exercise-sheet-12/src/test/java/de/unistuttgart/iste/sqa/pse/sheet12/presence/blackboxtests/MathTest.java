package de.unistuttgart.iste.sqa.pse.sheet12.presence.blackboxtests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests for selected Operation of class {@link Math}.
 */
public class MathTest {
	@Test
	public void exampleTest() {
		assertEquals(1, Math.floorDiv(2, 2));
	}

	@Test
	public void divisionByZeroTest() {
		assertThrows(ArithmeticException.class, () -> Math.floorDiv(1, 0));
		assertThrows(ArithmeticException.class, () -> Math.floorDiv(0, 0));
	}

	@Test
	public void divisorIsZeroTest() {
		assertEquals(0, Math.floorDiv(0, 1));
		assertEquals(0, Math.floorDiv(0, -4));
	}

	@Test
	public void dividendIsOneTest() {
		assertEquals(1, Math.floorDiv(1, 1));
		assertEquals(-3, Math.floorDiv(-3, 1));
	}

	@Test
	public void positiveResultTest() {
		assertEquals(1, Math.floorDiv(1, 1));
		assertEquals(0, Math.floorDiv(-3, -12));
		assertEquals(4, Math.floorDiv(-12, -3));
		assertEquals(1, Math.floorDiv(4, 3));
	}

	@Test
	public void negativeResultTest() {
		assertEquals(-1, Math.floorDiv(-1, 1));
		assertEquals(-1, Math.floorDiv(1, -1));
		assertEquals(-3, Math.floorDiv(6, -2));
		assertEquals(0, Math.floorDiv(12, 10));
	}

	@Test
	public void inputOutOfBoundsTest() {
		assertEquals(0, Math.floorDiv(1, Integer.MAX_VALUE));
		assertEquals(Integer.MAX_VALUE, Math.floorDiv(Integer.MAX_VALUE, 1));

		assertEquals(-1, Math.floorDiv(Integer.MIN_VALUE, Integer.MAX_VALUE));
	}


}
