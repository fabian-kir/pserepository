package de.unistuttgart.iste.sqa.pse.sheet06.presence.equality;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * Describe the purpose of this class here.
 *
 * @author (Your name)
 * @version (a version number or a date)
 */
public class EqualityHamsterGame extends SimpleHamsterGame {

	/**
	 * Creates a new EqualityHamsterGame.<br>
	 * Do not modify!
	 */
	public EqualityHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/Territory.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}

	@Override
	protected void run() {
		Hamster ronnie = new Hamster(game.getTerritory(), new Location(1, 1), Direction.EAST, 5);
		Hamster lisa = new Hamster(game.getTerritory(), ronnie.getLocation(), ronnie.getDirection(), 5);

		System.out.println(ronnie.getLocation().equals(new Location(1, 1)));
		System.out.println(ronnie.getLocation() == lisa.getLocation());
		System.out.println(ronnie.getLocation() == new Location(1, 1));

		System.out.println(ronnie.getDirection() == Direction.EAST);

		System.out.println(ronnie.equals(lisa));
		System.out.println(ronnie == lisa);
	}
}
