package de.unistuttgart.iste.sqa.pse.sheet05.homework;

import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * In this hamster-game {@code paule} gets four new friends.
 *
 * @author (Your name)
 * @version (A date or a version number)
 */
public class HamsterPartyGame extends SimpleHamsterGame {

	/**
	 * Constructor for the Party Game.
	 */
	public HamsterPartyGame() {
		this.loadTerritoryFromResourceFile("/territories/territory-hamsterparty.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}

	/**
	 * Starts the HamsterPartyGame.
	 *
	 */
	protected void run() {}
}
