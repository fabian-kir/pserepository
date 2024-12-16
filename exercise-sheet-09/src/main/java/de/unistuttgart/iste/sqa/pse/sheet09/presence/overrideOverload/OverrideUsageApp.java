package de.unistuttgart.iste.sqa.pse.sheet09.presence.overrideOverload;

/**
 * A class to test overriding.
 */
public class OverrideUsageApp {

	public static void main(final String[] args) {

		Library libraryOfAlexandria = new Library("libraryOfAlexandria");
		Opera stuttgartOperaHouse = new Opera("stuttgartOperaHouse");

		libraryOfAlexandria.printBuildingInfo();
		stuttgartOperaHouse.printBuildingInfo();

		Building building1 = libraryOfAlexandria;
		Building building2 = stuttgartOperaHouse;

		building1.printBuildingInfo();
		building2.printBuildingInfo();
	}
}
