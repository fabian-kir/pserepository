package de.unistuttgart.iste.sqa.pse.sheet12.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.datatypes.Size;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.external.model.HamsterGame;
import de.hamstersimulator.objectsfirst.external.model.TerritoryBuilder;
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
		assertEquals(0, game.getTerritory().getTotalGrainCount());

		game.stopGame();
	}
}
