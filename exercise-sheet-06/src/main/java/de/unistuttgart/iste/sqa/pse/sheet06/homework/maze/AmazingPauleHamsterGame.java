package de.unistuttgart.iste.sqa.pse.sheet06.homework.maze;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * Describe the purpose of this class here.
 *
 * @author Fabian Kirschenmann, Mika Hepper
 * @version (a version number or a date)
 */
public class AmazingPauleHamsterGame extends SimpleHamsterGame {

	/**
	 * Creates a new AmazingPauleHamsterGame.<br>
	 * Do not modify!
	 */
	public AmazingPauleHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/AmazingPauleTerritory.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}

	/**
	 * Ignore this method.<br>
	 * Put your code in passTheMaze()!
	 */
	@Override
	protected void run() {
		passTheMaze();
	}

	/**
	 * Brings paule through the Maze by always sticking to the left Wall
	 *
	 * @requires paule has to be initialized with mouthEmpty and only at the End of the Maze there should be one Grain
	 * @ensures paule finds his way out of the Maze and picks up the Grain
	 */
	void passTheMaze() {
		Hamster paule = this.paule;
		do {
			paule.move();
			paule.turnLeft(); // Checks if there is a Wall on paules left
			if (!paule.frontIsClear()) {
				paule.turnLeft();
				paule.turnLeft();
				paule.turnLeft(); //Checks if there is a Wall infront of paule
				if (!paule.frontIsClear()) {
					paule.turnLeft();
					paule.turnLeft();
					paule.turnLeft(); // Checks if there is a Wall on paules right
					if (!paule.frontIsClear()) {
						paule.turnLeft();
						paule.turnLeft();
						paule.turnLeft(); // It is a dead end and paule has to turn around
					}
				}
			}
			if (paule.grainAvailable()) {
				paule.turnLeft();
				paule.turnLeft(); // to face at the Exit of the Maze :)
				paule.pickGrain();
				paule.write("Found the Exit! :)");
			}
		}
		while (paule.frontIsClear() && paule.mouthEmpty());
	}
}
