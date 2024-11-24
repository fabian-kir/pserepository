package de.unistuttgart.iste.sqa.pse.sheet06.presence.primitives;

public class PrimitiveTypes {

	public static void main(final String[] args) {
		short maximumOfShort = 32767;

		int tenAsInteger = 10;
		int fourAsInteger = 4;
		double fourAsDouble = 4;

		double rootOfTwo = Math.sqrt(2);
		double zero = (rootOfTwo * rootOfTwo) - 2;

		char characterA = 'a';
		char characterB = 'b';

		System.out.println(maximumOfShort + 1);
		maximumOfShort++;
		System.out.println(maximumOfShort);
		System.out.println(tenAsInteger / fourAsInteger);
		System.out.println(tenAsInteger / fourAsDouble);
		System.out.println(zero);
		System.out.println(characterB - characterA);
	}
}
