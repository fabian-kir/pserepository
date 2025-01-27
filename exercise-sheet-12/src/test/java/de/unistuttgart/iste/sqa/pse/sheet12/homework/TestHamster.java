package de.unistuttgart.iste.sqa.pse.sheet12.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.datatypes.Size;
import de.hamstersimulator.objectsfirst.exceptions.FrontBlockedException;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.external.model.HamsterGame;
import de.hamstersimulator.objectsfirst.external.model.TerritoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class TestHamster {

	/**
	 * Size used in this test for both columns and rows.
	 */
	private static final int TERRITORY_SIZE = 4;

	/**
	 * Test creating a territory via API.
	 */
	@Test
	public void testConfiguredHamsterOnTerritory() {
		final HamsterGame game = new HamsterGame();
		final TerritoryBuilder territoryBuilder = game.getNewTerritoryBuilder();
		territoryBuilder.initializeTerritory(new Size(TERRITORY_SIZE, TERRITORY_SIZE));

		territoryBuilder.defaultHamsterAt(Location.ORIGIN, Direction.EAST, 0);
		territoryBuilder.grainAt(Location.from(1, 0));

		game.initialize(territoryBuilder);
		game.startGame();

		final Hamster paule = game.getTerritory().getDefaultHamster();

		/* Check that the territory has size TERRITORY_SIZE as width and length */
		assertEquals(
				new Size(TERRITORY_SIZE, TERRITORY_SIZE), game.getTerritory().getTerritorySize());
		/* Check that Paule is at position (0,0) */
		assertEquals(Location.ORIGIN, paule.getLocation());
		/* Check that territory has correct amount of grains on it */
		assertEquals(1, game.getTerritory().getTotalGrainCount()); // In testConfiguredHamsterOnTerritory wird ein Grain platziert (Zeile 30)

		game.stopGame();
	}

	@Test
	public void testMoveHamster() {
		final HamsterGame game = new HamsterGame();

		final TerritoryBuilder territoryBuilder = game.getNewTerritoryBuilder();
		territoryBuilder.initializeTerritory(new Size(TERRITORY_SIZE, TERRITORY_SIZE));
		territoryBuilder.defaultHamsterAt(Location.ORIGIN, Direction.EAST, 0);
		territoryBuilder.wallAt(Location.from(0, 2));

		game.initialize(territoryBuilder);
		game.startGame();

		final Hamster paule = game.getTerritory().getDefaultHamster();

		paule.move();

		assertEquals(Location.from(0, 1), paule.getLocation());

		assertThrows(FrontBlockedException.class, paule::move);

		game.stopGame();
	}

	@Test
	public void testPickGrain() {
		final HamsterGame game = new HamsterGame();
		final TerritoryBuilder territoryBuilder = game.getNewTerritoryBuilder();
		territoryBuilder.initializeTerritory(new Size(TERRITORY_SIZE, TERRITORY_SIZE));

		territoryBuilder.defaultHamsterAt(Location.ORIGIN, Direction.EAST, 0);
		territoryBuilder.grainAt(Location.from(0, 0));

		game.initialize(territoryBuilder);
		game.startGame();

		final Hamster paule = game.getTerritory().getDefaultHamster();
		paule.pickGrain();

		/* Checks that paule has one Grain in his mouth*/
		assertEquals(0, game.getTerritory().getTotalGrainCount(),"Paule succesfully picked up the grain");

		game.stopGame();
	}
}