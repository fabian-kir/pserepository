package de.unistuttgart.iste.sqa.pse.sheet05.presence;

import de.hamstersimulator.objectsfirst.external.model.Territory;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * Please describe this class here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public final class ExerciseHamsterGame extends SimpleHamsterGame {

	public ExerciseHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/territory.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}

	/**
	 * Create a StringBuilde object and use is to print the following to the console:
	 * <li> Territory size
	 * <li> Amount of Grains
	 * <li> Number of hamsters in the field
	 *
	 */
	@Override
	protected void run() {
		final Territory territory = game.getTerritory();
		// TODO implements
	}
}
