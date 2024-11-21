package de.unistuttgart.iste.sqa.pse.sheet05.presence.controlflow.exercise1.games;

import de.unistuttgart.iste.sqa.pse.sheet05.presence.controlflow.BaseControlFlowHamsterGame;

public class PrimaryPickOrMoveGame extends BaseControlFlowHamsterGame {

	public PrimaryPickOrMoveGame() {
		super("/territories/territoryExample05-4.1.ter");
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
