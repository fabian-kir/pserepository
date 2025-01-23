package de.unistuttgart.iste.sqa.pse.sheet11.presence.collectionstreams;

import java.util.List;

/**
 * In this class you are supposed to train your skills in using the Java Streams
 * API and Collections. Implement the four empty operations in this class
 * properly by using streams. Do not forget to use defensive programming and to
 * comment your code!
 */
public final class StreamsAndFilterExercise {

	public static void main(String[] args) {
		final StudentRecord record = new StudentRecord();
		DataGenerator.fillRecordWithTestData(record);
		DataGenerator.fillRecordWithRealLifePSEMarks(record);

		System.out.println("--------------------------");
		System.out.println("TEST FOR STREAMS + LAMBDAS:");
		System.out.println("--------------------------");

		System.out.println();
		System.out.println("1) All student names:");
		printAllStudentNames(record);
		System.out.println();
		System.out.println("2) Number of students older than 23:");
		printNumberOfStudentsOlderThan(record, 23);
		System.out.println();
		System.out.println("3) Students older than 23:");
		printStudentNamesOlderThan(record, 23);
		System.out.println();
		System.out.println("4) Students older than 25 and failed PSE:");
		printStudentNamesOlderThanAndFailedExam(record, 25, "PSE");
		System.out.println();

		System.out.println("--------------------------");
		System.out.println("TEST WITHOUT STREAMS + LAMBDAS:");
		System.out.println("--------------------------");

		System.out.println();
		System.out.println("1) All student names:");
		printAllStudentNamesChallenge(record);
		System.out.println();
		System.out.println("2) Number of students older than 23:");
		printNumberOfStudentsOlderThanChallenge(record, 23);
		System.out.println();
		System.out.println("3) Students older than 23:");
		printStudentNamesOlderThanChallenge(record, 23);
		System.out.println();
		System.out.println("4) Students older than 25 and failed PSE:");
		printStudentNamesOlderThanAndFailedExamChallenge(record, 25, "PSE");
	}

	private static void printAllStudentNames(final StudentRecord record) {
		record.getAllStudents().stream().map(Student::getName).forEach(System.out::println);
	}

	private static void printNumberOfStudentsOlderThan(final StudentRecord record, final int olderThan) {
		long number = record.getAllStudents().stream().filter(student -> student.getAge() > olderThan).count();
		System.out.println(number);
	}

	private static void printStudentNamesOlderThan(final StudentRecord record, final int olderThan) {
		record.getAllStudents().stream().filter(student -> student.getAge() > olderThan).map(Student::getName).forEach(System.out::println);
	}

	private static void printStudentNamesOlderThanAndFailedExam(
			final StudentRecord record, final int olderThan, final String exam) {
		record.getAllStudents().stream().filter(student -> (student.getAge() > olderThan)&&(student.getExam(exam).getMark() > 4.0)).map(Student::getName).forEach(System.out::println);
	}

	private static void printAllStudentNamesChallenge(final StudentRecord record) {

	}

	private static void printNumberOfStudentsOlderThanChallenge(final StudentRecord record, final int olderThan) {
		// TODO: implement exercise 2 (f)
	}

	private static void printStudentNamesOlderThanChallenge(final StudentRecord record, final int olderThan) {
		// TODO: implement exercise 2 (f)
	}

	private static void printStudentNamesOlderThanAndFailedExamChallenge(
			final StudentRecord record, final int olderThan, final String exam) {
		// TODO: implement exercise 2 (f)
	}
}
