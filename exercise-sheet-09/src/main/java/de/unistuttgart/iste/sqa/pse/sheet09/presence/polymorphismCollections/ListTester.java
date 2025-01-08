package de.unistuttgart.iste.sqa.pse.sheet09.presence.polymorphismCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * A class to test list implementations.
 */
public class ListTester {

	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();
		ArrayList<String> arrayList = new ArrayList<String>();
		List<String> syncedList = Collections.synchronizedList(new ArrayList<>());

		add1000Strings(linkedList);
		add1000Strings(arrayList);
		add1000Strings(syncedList);

		linkedList = new LinkedList<String>();
		arrayList = new ArrayList<String>();
		syncedList = Collections.synchronizedList(new ArrayList<>());

		add10_000Strings(linkedList);
		add10_000Strings(arrayList);
		add10_000Strings(syncedList);
	}

	// Add operations for exercise 2 (b), (d) and (e) here.
	public static List<String> add1000Strings(List<String> inputList) {
		Timer timer = new Timer();
		
		timer.start();

		for (int i = 0; i < 1000; i++) {
			inputList.add(String.valueOf(i));
		}

		timer.stop();
		timer.printResult();

		return inputList;
    }

	public static List<String> add10_000Strings(List<String> inputList) {
		Timer timer = new Timer();

		timer.start();

		for (int i = 0; i < 10_000; i++) {
			inputList.add(String.valueOf(i));
		}


		timer.stop();
		timer.printResult();

		return inputList;
	}
}
