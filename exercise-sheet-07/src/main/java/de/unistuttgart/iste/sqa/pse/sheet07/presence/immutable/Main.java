package de.unistuttgart.iste.sqa.pse.sheet07.presence.immutable;

public class Main {

	public static void main(String[] args) {
		Address neueAdresse = new Address("Hospitalstraße", 1, "70741", "Stuttgart");
		MyImmutableStudent student = new MyImmutableStudent("Mika", 1, neueAdresse);

		System.out.printf(
				"Name lautet %s \nund die Matrikelnummer ist %d", student.getName(), student.getMatrikelnumber()
		);
	}
}
