package de.unistuttgart.iste.sqa.pse.sheet06.presence.stairs;

import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;
import de.unistuttgart.iste.sqa.pse.sheet06.presence.stairs.exceptions.UnsurmountableStepException;
import de.unistuttgart.iste.sqa.pse.sheet06.presence.stairs.exceptions.ClimbingAbortedException;

/**
 * Describe the purpose of this class here.
 *
 * @author Fabian Kirschenmann, Mika Hepper
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
		this.loadTerritoryFromResourceFile("/territories/TooWideStairsTerritory.ter");
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
	 * @ensures paule is looking into Direction.EAST afterwards
	 * @throws UnsurmountableStepException
	 */
	private void movePauleToNextStep() throws UnsurmountableStepException {
		paule.turnLeft();
		paule.move();

		this.turnPauleRight();

		if (paule.frontIsClear()) {
			while(paule.frontIsClear()) {
				paule.move();
			}
		} else {
			throw new UnsurmountableStepException("The !?!Oo1ga Bo:)oga!?! stair you're trying to climb appears to be to high or not a stair at all.");
		}


	}

	/**
	 * TODO Write JavaDoc here
	 * @requires paule is looking to Direction.EAST
	 * @return true if paule reached the TOp
	 */
	private boolean hasReachedTop() {
		// TODO implement 4 (b) here

		if (paule.frontIsClear()) {
			return true;
		}
		return false;
	}

	/**
	 * TODO Write JavaDoc here
	 */
	private void climbStairs() {
		// TODO implement 4 (c) here
		while (!hasReachedTop()) {
            try {
                this.movePauleToNextStep();
            } catch (UnsurmountableStepException e) {
                throw new ClimbingAbortedException("Climbing the stairs is not possible, because at least one step is to tall to be climbed.");
            }

        }
		paule.write("Ooga Booga");
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
