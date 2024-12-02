package de.unistuttgart.iste.sqa.pse.sheet07.homework.exceptions;

import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * A SimpleHamsterGame with exceptions
 *
 * @author (your name)
 */
public class LazyHamsterGame extends SimpleHamsterGame {

	/**
	 * This constructor is used for loading a territory for the game and for displaying it.
	 * Do not modify.
	 */
	public LazyHamsterGame(final String territoryFile) {
		this.loadTerritoryFromResourceFile(territoryFile);
		this.displayInNewGameWindow();
		game.startGame();
	}

	/**
	 * Do not modify this operation.
	 */
	@Override
	protected void run() {
		moveMultipleSteps(5);
	}

	// TODO add documentation with contracts here
	public void tryToMove() {
		// TODO Implement here.
	}

	// TODO add documentation with contracts here
	public void moveMultipleSteps(int numberOfSteps) {
		// TODO Implement here.
	}

	// TODO add documentation with contracts here
	public boolean isCaged() {
		// TODO Implement here.
		return true; // delete this line, if necessary.
	}
}
