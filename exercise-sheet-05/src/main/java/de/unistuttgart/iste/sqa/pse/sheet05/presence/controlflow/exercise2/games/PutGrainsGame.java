package de.unistuttgart.iste.sqa.pse.sheet05.presence.controlflow.exercise2.games;

import de.unistuttgart.iste.sqa.pse.sheet05.presence.controlflow.BaseControlFlowHamsterGame;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PutGrainsGame extends BaseControlFlowHamsterGame {

	/**
	 * List of grains the hamster should try to put down on to the tile
	 */
	private final List<Integer> randomGrainPuts;

	public PutGrainsGame() {
		super("/territories/territoryExample05-6.ter");
		randomGrainPuts = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1, 5))
				.limit(2)
				.collect(Collectors.toList());
	}

	/**
	 * Starts the game with a predetermined territory and lets Paule walk through a short test scenario.
	 * Do not modify!
	 */
	@Override
	protected void run() {
		while (paule.grainAvailable()) {
			paule.pickGrain();
		}

		for (int i = 0; i < 11; i++) {
			paule.move();
		}
		putGrains(randomGrainPuts.get(0));
		putGrains(randomGrainPuts.get(1));
	}

	/**
	 * Gets the list of numbers of grains the hamster will attempt to put down when the game is run
	 *
	 * @return Unmodifiable List of numbers of grains
	 */
	public List<Integer> getRandomGrainPuts() {
		return Collections.unmodifiableList(randomGrainPuts);
	}
}
