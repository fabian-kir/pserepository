package de.unistuttgart.iste.sqa.pse.sheet05.presence.controlflow;

import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * A new HamsterGame to try out some control flow structures.
 *
 * @author (your name)
 * @version (version number or date)
 */
public abstract class BaseControlFlowHamsterGame extends SimpleHamsterGame {

	/**
	 * Constructor for the BaseControlFlowHamsterGame class.
	 * Do not modify!
	 *
	 * @param territoryFile file-path to the .ter file specifying the game territory
	 */
	public BaseControlFlowHamsterGame(final String territoryFile) {
		this.loadTerritoryFromResourceFile(territoryFile);
		this.displayInNewGameWindow();
		game.startGame();
	}

	/**
	 * Move paule to the next wall.
	 *
	 * Ensures that paule's front is not clear.
	 *
	 * This is an example for an operation with pre- and postconditions and
	 * loop(in)variants in natural language.
	 */
	protected void moveToWall() {
		/*@
		@ loop_invariant paule moved number of already executed loop iterations steps.
		@ decreasing number of tiles between paule and the next wall.
		@*/
		while (paule.frontIsClear()) {
			paule.move();
		}
	}

	/*
	 * Please implement your solutions into the following methods.
	 * Remember to add the appropriate JavaDoc documentation and pre-post conditions for each operation
	 * as well as the variants and loop invariants for any loops that are part of your implementation.
	 */

	protected void pickGrainIfAvailable() {
		// TODO: Please implement according to exercise 1 (c-i)
	}

	protected void pickAllGrains() {
		// TODO: Please implement according to exercise 1 (c-ii)
	}

	protected void multiMove(Integer times) {
		// TODO: Please implement according to exercise 1 (c-iii)
	}

	protected void pickGrainOrMove() {
		// TODO: Please implement according to exercise 1 (c-iv)
	}

	protected void pickAllGrainsOnNonEmptyTile() {
		// TODO: Please implement according to exercise 1 (c-v)
	}

	protected void putGrains(Integer amountOfGrains) {
		// TODO: Please implement according to exercise 2 (a)
	}

	protected void emptyMouth() {
		// TODO: Please implement according to exercise 2 (b)
	}

	protected void cleanTerritory() {
		// TODO: Please implement according to exercise 2 (c)/(d)
	}
}
