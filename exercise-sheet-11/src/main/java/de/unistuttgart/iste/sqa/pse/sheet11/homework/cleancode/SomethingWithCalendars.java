package de.unistuttgart.iste.sqa.pse.sheet11.homework.cleancode;

import static java.lang.Integer.parseInt;

import java.util.Calendar;
import java.util.Scanner;

public class SomethingWithCalendars {
	public static void main(final String[] args) throws NoValidPatternInInputStringException {
		String userInput = getUserInput();
		WeekdayComputer weekdayComputer = WeekdayComputer.fromInputString(userInput);
		System.out.println(weekdayComputer.getWeekdayString());
	}

	public static String getUserInput() {
		final Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the input for SomethingWithCalendars: (press enter to confirm)");
		return scanner.nextLine();
	}


}
