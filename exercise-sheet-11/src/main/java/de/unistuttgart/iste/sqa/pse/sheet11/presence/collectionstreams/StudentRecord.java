package de.unistuttgart.iste.sqa.pse.sheet11.presence.collectionstreams;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a set of students. The record can be manipulated by adding new students. There is no possiblity
 * to remove students after inserting them to the record.
 */
public final class StudentRecord {

	// @ invariant students != null;
	private final Set<Student> students;

	public StudentRecord() {
		this.students = new HashSet<Student>();
	}

	/*@
	@ requires student != null;
	@*/
	/**
	 * Adds a student to the current record
	 * @param student student that will be added
	 * @throws IllegalArgumentException if student is {@code null}.
	 */
	public void addStudent(final Student student) throws IllegalArgumentException {
		if (student == null) {
			throw new IllegalArgumentException("The given reference to a student object must not be null!");
		}
		students.add(student);
	}

	/**
	 * Get the set of all students that are stored in this record.
	 */
	public Set<Student> getAllStudents() {
		return students;
	}
}
