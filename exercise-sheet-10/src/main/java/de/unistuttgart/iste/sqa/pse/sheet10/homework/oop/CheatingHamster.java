package de.unistuttgart.iste.sqa.pse.sheet10.homework.oop;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.external.model.Territory;

/**
 * An especially eager Hamster.
 */
public class CheatingHamster extends Hamster {

	/**
	 * Create a new instance of {@link CheatingHamster}.
	 *
	 * @param territory territory to create the new hamster on. Must not be {@code null}.
	 * @param location location to create the new hamster at. Must not be {@code null}. Must be on the territory and must not be blocked by a wall.
	 * @param direction direction the new hamster looks into. Must not be {@code null}.
	 * @param newGrainCount number of grains the new hamster holds.
	 */
	public CheatingHamster(
			final Territory territory, final Location location, final Direction direction, final int newGrainCount) {
		super(territory, location, direction, newGrainCount);
	}

	@Override
	public void move() {
		super.move();
		super.move();
	}
}
