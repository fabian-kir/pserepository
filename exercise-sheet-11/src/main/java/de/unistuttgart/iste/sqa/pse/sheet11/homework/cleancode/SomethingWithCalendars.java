package de.unistuttgart.iste.sqa.pse.sheet11.homework.cleancode;

import static java.lang.Integer.parseInt;

import java.util.Calendar;
import java.util.Scanner;

public class SomethingWithCalendars {

	static String[] weekDays = new String[] {"Sun", "Mon", "Tues", "Wednes", "Thurs", "Fri", "Satur"};

	static void setCalendarDate(final Calendar cal, final String date, final String sep) {
		final String[] fs = date.split(sep);
		cal.set(parseInt(fs[0]), parseInt(fs[1]) - 1, parseInt(fs[2]));
	}

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the input for SomethingWithCalendars: (press enter to confirm)");
		final String input = scanner.nextLine();
		final Calendar cal = Calendar.getInstance();
		if (input.indexOf("-") >= 0) {
			setCalendarDate(cal, input, "-");
		} else if (input.indexOf("/") >= 0) {
			setCalendarDate(cal, input, "/");
		} else if (input.indexOf(".") >= 0) {
			final String[] fs = input.split(".");
			cal.set(parseInt(fs[0]), parseInt(fs[1]) - 1, parseInt(fs[2]));
		}
		final int wd = cal.get(Calendar.DAY_OF_WEEK);
		System.out.printf("%sday\n", weekDays[wd - 1]);
	}
}
