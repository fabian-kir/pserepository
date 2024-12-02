package de.unistuttgart.iste.sqa.pse.sheet07.presence.springcleaning;

import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * This class is used to solve some easy tasks.
 */
public class SpringCleaningHamsterGame extends SimpleHamsterGame {

	/**
	 * Creates a new SpringCleaningHamsterGame.<br>
	 * Do not modify!
	 */
	public SpringCleaningHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/ArtemisPaule.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}

	@Override
	protected void run() {
		// Put your code for part A exercise 3 (f), 4 (d) and 4 (e) here.
	}
}
