package de.unistuttgart.iste.sqa.pse.sheet05.presence.controlflow.exercise1.games;

import de.unistuttgart.iste.sqa.pse.sheet05.presence.controlflow.BaseControlFlowHamsterGame;

public class PickAllGrainsGame extends BaseControlFlowHamsterGame {

	public PickAllGrainsGame() {
		super("/territories/territoryExample05-2.ter");
	}

	/**
	 * Starts the game with a predetermined territory and lets Paule walk through a short test scenario.
	 * Do not modify!
	 */
	@Override
	protected void run() {
		for (int i = 0; i < 10; i++) {
			pickAllGrains();
			paule.move();
		}
	}
}
