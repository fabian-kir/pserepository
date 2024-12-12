package de.unistuttgart.iste.sqa.pse.sheet08.presence.hamster;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.exceptions.FrontBlockedException;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.external.model.Territory;

/**
 * A great hamster who can do more than a normal hamster.
 */
public class MyGreatHamster extends Hamster {

	public MyGreatHamster(
			final Territory territory, final Location location, final Direction direction, final int newGrainCount
	) {
		super(territory, location, direction, newGrainCount);
	}

	public void turnRight() {
		for (int i = 0; i<3; i++) {
			this.turnLeft();
		}
	}

	public void pickAllGrains() {
		while (this.grainAvailable()) {
			this.pickGrain();
		}
	}

	public void multiMove(final int stepCounter) throws FrontBlockedException {
		for (int steps = 0; steps<stepCounter; steps++) {
			try {
				this.move();
			} catch (FrontBlockedException frontBlockedException) {
				throw new FrontBlockedException();
			}
		}
	}
}
