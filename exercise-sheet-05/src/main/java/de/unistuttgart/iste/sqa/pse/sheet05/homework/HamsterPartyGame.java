package de.unistuttgart.iste.sqa.pse.sheet05.homework;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.external.model.Territory;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;
import javafx.scene.control.skin.TextInputControlSkin;

/**
 * In this hamster-game {@code paule} gets four new friends.
 *
 * @author Fabian Kirschenmann, Mika Hepper
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
	protected void run() {
		Location adamsLocation = new Location(1,4);
		Location evesLocation = new Location(5,1);
		Location eriksLocation = new Location(6,4);
		Location lupinsLocation = new Location(5,5);
		Hamster Adam = new Hamster(game.getTerritory(), adamsLocation, Direction.SOUTH, 0);
		Hamster Eve = new Hamster(game.getTerritory(), evesLocation, Direction.EAST, 0);
		Hamster Erik = new Hamster(game.getTerritory(), eriksLocation, Direction.NORTH, 0);
		Hamster Lupin = new Hamster(game.getTerritory(), lupinsLocation, Direction.WEST, 0);
	}
}
// Party! lecker Bierchen!
// test