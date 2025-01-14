package de.unistuttgart.iste.sqa.pse.sheet10.homework.oop;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
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
	protected void run() {
		Hamster cheatingHamster = new CheatingHamster(this.game.getTerritory(), new Location(1, 1), Direction.EAST, 0);

		cheatingHamster.move();
		cheatingHamster.move();
		cheatingHamster.move();

		Hamster lazyHamster = new LazyHamster(this.game.getTerritory(), new Location(1, 1), Direction.EAST, 0);

		lazyHamster.move();
		lazyHamster.move();
		lazyHamster.move();
	}
}
