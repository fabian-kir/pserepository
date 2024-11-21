package de.unistuttgart.iste.sqa.pse.sheet05.presence.controlflow.exercise1.games;

import de.unistuttgart.iste.sqa.pse.sheet05.presence.controlflow.BaseControlFlowHamsterGame;

public class SecondaryPickOrMoveGame extends BaseControlFlowHamsterGame {

	public SecondaryPickOrMoveGame() {
		super("/territories/territoryExample05-4.2.ter");
	}

	/**
	 * Starts the game with a predetermined territory and lets Paule walk through a short test scenario.
	 * Do not modify!
	 */
	@Override
	protected void run() {
		pickGrainOrMove();
	}
}
