package de.unistuttgart.iste.sqa.pse.sheet06.presence.stairs;

import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;
import de.unistuttgart.iste.sqa.pse.sheet06.presence.stairs.exceptions.UnsurmountableStepException;

/**
 * Describe the purpose of this class here.
 *
 * @author (Your name)
 * @version (a version number or a date)
 */
public class StairsHamsterGame extends SimpleHamsterGame {

	/**
	 * Creates a new {@link StairsHamsterGame}.<br>
	 */
	public StairsHamsterGame() {
		// replace "/territories/StairsTerritory.ter" in the following line of code with
		// "/territories/TooHighStairsTerritory.ter" or
		// "/territories/TooWideStairsTerritory.ter" to load other territories.
		this.loadTerritoryFromResourceFile("/territories/StairsTerritory.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}

	/**
	 * Ignore this method.<br>
	 * Put your code in {@link StairsHamsterGame#climbStairs}!
	 */
	@Override
	protected void run() {
		climbStairs();
	}

	/**
	 * TODO Write JavaDoc here
	 * 
	 * @throws UnsurmountableStepException
	 */
	private void movePauleToNextStep() throws UnsurmountableStepException {
		// TODO implement 4 (a) here
	}

	/**
	 * TODO Write JavaDoc here
	 * 
	 * @return
	 */
	private boolean hasReachedTop() {
		// TODO implement 4 (b) here
		return true; // TODO replace this line with your implementation
	}

	/**
	 * TODO Write JavaDoc here
	 */
	private void climbStairs() {
		// TODO implement 4 (c) here
	}

	/**
	 * Turns Paule 90 degree to his right.
	 */
	private void turnPauleRight() {
		paule.turnLeft();
		paule.turnLeft();
		paule.turnLeft();
	}
}
