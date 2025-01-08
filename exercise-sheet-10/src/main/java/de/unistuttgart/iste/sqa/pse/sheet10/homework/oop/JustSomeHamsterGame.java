package de.unistuttgart.iste.sqa.pse.sheet10.homework.oop;

import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * Just some game.
 *
 * This game is not required to solve the exercise sheet. It exists merely in
 * case you want to try out some things with instances of {@link LazyHamster} or
 * {@link CheatingHamster}.
 *
 */
public final class JustSomeHamsterGame extends SimpleHamsterGame {

	public JustSomeHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/territory.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}

	@Override
	protected void run() {}
}
