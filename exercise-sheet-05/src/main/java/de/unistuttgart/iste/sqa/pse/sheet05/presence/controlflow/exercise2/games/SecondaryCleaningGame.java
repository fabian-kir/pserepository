package de.unistuttgart.iste.sqa.pse.sheet05.presence.controlflow.exercise2.games;

import de.unistuttgart.iste.sqa.pse.sheet05.presence.controlflow.BaseControlFlowHamsterGame;

public class SecondaryCleaningGame extends BaseControlFlowHamsterGame {

	public SecondaryCleaningGame() {
		super("/territories/territoryExample05-8.2.ter");
	}

	/**
	 * Starts the game with a predetermined territory and lets Paule walk through a short test scenario.
	 * Do not modify!
	 */
	@Override
	protected void run() {
		cleanTerritory();
	}
}
