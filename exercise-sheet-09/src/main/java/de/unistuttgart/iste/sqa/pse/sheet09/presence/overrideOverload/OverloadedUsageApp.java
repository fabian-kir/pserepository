package de.unistuttgart.iste.sqa.pse.sheet09.presence.overrideOverload;

/**
 * A class to test overloading.
 */
public class OverloadedUsageApp {

	public static void main(final String[] args) {
		Library libraryOfAlexandria = new Library("libraryOfAlexandria");
		Opera stuttgartOperaHouse = new Opera("stuttgartOperaHouse");

		OverloadedUsageApp.printBuildingInfo(libraryOfAlexandria);
		OverloadedUsageApp.printBuildingInfo(stuttgartOperaHouse);

		Building building1 = libraryOfAlexandria;
		Building building2 = stuttgartOperaHouse;

		OverloadedUsageApp.printBuildingInfo(building1);
		OverloadedUsageApp.printBuildingInfo(building2);
	}

	/**
	 * Print information about the given building.
	 *
	 * @param building building to print information about.
	 */
	private static void printBuildingInfo(final Building building) {
		System.out.format("Printing Information for a BUILDING:\n");
		building.printBuildingInfo();
	}

	/**
	 * Print information about the given library.
	 *
	 * @param aLibrary library to print information about.
	 */
	private static void printBuildingInfo(final Library aLibrary) {
		System.out.format("Printing Information for a LIBRARY:\n");
		aLibrary.printBuildingInfo();
	}

	/**
	 * Print information about the given opera.
	 *
	 * @param aOpera opera to print information about.
	 */
	private static void printBuildingInfo(final Opera aOpera) {
		System.out.format("Printing Information for an OPERA:\n");
		aOpera.printBuildingInfo();
	}
}
