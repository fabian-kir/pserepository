package de.unistuttgart.iste.sqa.pse.sheet11.presence.collectionstreams;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Represents a student.
 *
 * @author mfrank
 *
 */
public final class Student {
	/*@
	@ invariant name != null && birthday != null && gender != null && emailAddress != null && writtenExam != null;
	@*/

	public enum Sex {
		MALE,
		FEMALE
	}

	private final String name;
	private final LocalDate birthday;
	private final Sex gender;
	private final String emailAddress;
	private final Map<String, Exam> writtenExams;

	/*@
	@ requires name != null && birthday != null && gender != null && email != null;
	@*/
	/**
	 * Constructor for a student.
	 *
	 * @param name
	 * @param birthday
	 * @param gender
	 * @param email
	 * @throws IllegalArgumentException if any of name, birthday, gender or email is {@code null}.
	 */
	public Student(final String name, final LocalDate birthday, final Sex gender, final String email)
			throws IllegalArgumentException {

		if (name == null || birthday == null || gender == null || email == null) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = email;
		this.writtenExams = new HashMap<String, Exam>();
	}

	/*@
	@ requires exam != null;
	@*/
	/**
	 * Adds an exam to the exam-list of this student. It uses a map and the name of the exam as key.
	 * To get the exam use getExam(key) for a single exam or getWrittenExams() for all exams.
	 *
	 * @param exam
	 * @throws IllegalArgumentException if exam is {@code null}.
	 */
	public void addExam(final Exam exam) throws IllegalArgumentException {
		if (exam == null) {
			throw new IllegalArgumentException();
		}
		writtenExams.put(exam.getSubject(), exam);
	}

	/**
	 * @return the age in years (int) of the student.
	 */
	public int getAge() {
		return (int) ChronoUnit.YEARS.between(birthday, LocalDate.now());
	}

	/*@
	@ requires examTag != null;
	@*/
	/**
	 * Returns the exam for a given name.
	 *
	 * @param examTag name of the exam
	 * @return exam for given key
	 * @throws IllegalArgumentException if examTag is {@code null}.
	 */
	public /*@ pure @*/ Exam getExam(final String examTag) throws IllegalArgumentException {
		if (examTag == null) {
			throw new IllegalArgumentException();
		}
		return writtenExams.get(examTag);
	}

	public /*@ pure @*/ String getName() {
		return name;
	}

	public /*@ pure @*/ LocalDate getBirthday() {
		return birthday;
	}

	public /*@ pure @*/ Sex getGender() {
		return gender;
	}

	public /*@ pure @*/ String getEmailAddress() {
		return emailAddress;
	}

	public /*@ pure @*/ Map<String, Exam> getWrittenExams() {
		return Collections.unmodifiableMap(writtenExams);
	}
}
