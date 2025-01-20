package de.unistuttgart.iste.sqa.pse.sheet11.presence.collectionstreams;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Generates semi-random testdata for Students and exams
 *
 * @author mfrank
 */
public final class DataGenerator {

	private static final Random markGenerator = new Random();

	/**
	 * @return Random number between 1.0 and 6.0
	 */
	private static int getMarks() {
		return markGenerator.nextInt(5) + 1;
	}

	/*@
	@ requires record != null;
	@*/
	/**
	 * Adds an Exam with the name "PSE" to all students in the given list and
	 * generates a random mark between 1.0 and 6.0
	 *
	 * @param record
	 * @throws IllegalArgumentException if record is {@code null}.
	 */
	public static void fillRecordWithRealLifePSEMarks(final StudentRecord record) {
		if (record == null) {
			throw new IllegalArgumentException();
		}
		for (final Student aStudent : record.getAllStudents()) {
			aStudent.addExam(new Exam(getMarks(), "PSE"));
		}
	}

	/**
	 * Adds 20 Students to the given student list. All with different names, ages,
	 * sex, and email
	 *
	 * @param record
	 * @throws IllegalArgumentException if record is {@code null}.
	 */
	public static void fillRecordWithTestData(final StudentRecord record) {
		if (record == null) {
			throw new IllegalArgumentException();
		}

		final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		record.addStudent(
				new Student("John", LocalDate.parse("20-08-1996", df), Student.Sex.MALE, "john@uni-stuttgart.de"));

		record.addStudent(
				new Student("Tim", LocalDate.parse("07-07-1993", df), Student.Sex.MALE, "tim@uni-stuttgart.de"));

		record.addStudent(
				new Student("Egon", LocalDate.parse("08-06-1992", df), Student.Sex.MALE, "egon@uni-stuttgart.de"));

		record.addStudent(
				new Student("Lisa", LocalDate.parse("12-05-1991", df), Student.Sex.FEMALE, "lisa@uni-stuttgart.de"));

		record.addStudent(
				new Student("Paul", LocalDate.parse("13-03-1995", df), Student.Sex.MALE, "paul@uni-stuttgart.de"));

		record.addStudent(
				new Student("Anton", LocalDate.parse("14-04-1994", df), Student.Sex.MALE, "anton@uni-stuttgart.de"));

		record.addStudent(new Student(
				"Lorelei", LocalDate.parse("15-12-1993", df), Student.Sex.FEMALE, "lorelei@uni-stuttgart.de"));

		record.addStudent(
				new Student("Tina", LocalDate.parse("11-11-2000", df), Student.Sex.FEMALE, "tina@uni-stuttgart.de"));

		record.addStudent(new Student(
				"Vincent", LocalDate.parse("31-10-1995", df), Student.Sex.MALE, "vincent@uni-stuttgart.de"));

		record.addStudent(
				new Student("Marie", LocalDate.parse("27-01-1996", df), Student.Sex.FEMALE, "marie@uni-stuttgart.de"));

		record.addStudent(
				new Student("Nina", LocalDate.parse("28-02-1997", df), Student.Sex.FEMALE, "nina@uni-stuttgart.de"));

		record.addStudent(
				new Student("Leon", LocalDate.parse("13-03-1998", df), Student.Sex.MALE, "leon@uni-stuttgart.de"));

		record.addStudent(new Student(
				"Tamara", LocalDate.parse("17-09-1991", df), Student.Sex.FEMALE, "tamara@uni-stuttgart.de"));

		record.addStudent(
				new Student("Hanna", LocalDate.parse("19-10-1992", df), Student.Sex.FEMALE, "hanna@uni-stuttgart.de"));

		record.addStudent(
				new Student("Tanja", LocalDate.parse("01-11-1993", df), Student.Sex.FEMALE, "tanja@uni-stuttgart.de"));

		record.addStudent(new Student(
				"Princess Diamond",
				LocalDate.parse("11-01-1991", df),
				Student.Sex.FEMALE,
				"prince.d@uni-stuttgart.de"));

		record.addStudent(
				new Student("Thor", LocalDate.parse("02-02-1996", df), Student.Sex.MALE, "HAMMER@uni-stuttgart.de"));

		record.addStudent(
				new Student("Mario", LocalDate.parse("02-04-1988", df), Student.Sex.MALE, "mario@uni-stuttgart.de"));

		record.addStudent(new Student(
				"Lara Croft", LocalDate.parse("15-11-1998", df), Student.Sex.FEMALE, "L.C.@uni-stuttgart.de"));

		record.addStudent(new Student(
				"Scooby-Doo", LocalDate.parse("12-02-2008", df), Student.Sex.MALE, "scooby@uni-stuttgart.de"));
	}
}
