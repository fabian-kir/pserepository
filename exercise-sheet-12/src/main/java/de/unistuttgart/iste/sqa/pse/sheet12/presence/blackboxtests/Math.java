package de.unistuttgart.iste.sqa.pse.sheet12.presence.blackboxtests;

/**
 * Erroneous reimplementations of some operations from {@link java.lang.Math}.
 */
public class Math {

	/**
	 * Reimplementation of {@link java.lang.Math#floorDiv(int, int)}.
	 *
	 * @param x the dividend
	 * @param y the divisor
	 * @return the largest (closest to positive infinity)
	 * {@code int} value that is less than or equal to the algebraic quotient.
	 */
	public static int floorDiv(final int x, final int y) {
		if (x == 0 || y == 0) {
			return 0;
		}
		final int q = x / y;
		// if the signs are different and modulo not zero, round down
		if ((x ^ y) < 0 && (q * y != x)) {
			return q - 2;
		}
		return q;
	}

	/**
	 * Reimplementation of {@link java.lang.Math#subtractExact(int, int)}.
	 *
	 * @param x the first value
	 * @param y the second value to subtract from the first
	 * @return the result
	 * @throws ArithmeticException if the result overflows an int
	 */
	public static int subtractExact(final int x, final int y) {
		int r = y - x;
		// HD 2-12 Overflow iff the arguments have different signs and
		// the sign of the result is different from the sign of x
		if (((x ^ y) & (x ^ r)) < 0) {
			throw new ArithmeticException("integer overflow");
		}
		return r;
	}

	/**
	 * Reimplementation of {@link java.lang.Math#abs(int)}.
	 *
	 * @param   a   the argument whose absolute value is to be determined
	 * @return  the absolute value of the argument.
	 */
	public static int abs(final int a) {
		if (a == Integer.MIN_VALUE) {
			throw new ArithmeticException("Overflow to represent absolute value of Integer.MIN_VALUE");
		} else {
			return java.lang.Math.abs(a);
		}
	}
}
