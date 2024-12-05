package de.unistuttgart.iste.sqa.pse.sheet07.presence.springcleaning;
import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.external.model.Hamster;

public class SpringCleaning {
    Hamster cleaningHamster;

    public SpringCleaning(Hamster cleaningHamster) {
        this.cleaningHamster = cleaningHamster;
    }

    public void turnRight() {
        for (int i = 0; i < 3; i++) {
            this.cleaningHamster.turnLeft();
        }
    }


    public void turnToDirection (Direction direction) {
        while (!(direction == this.cleaningHamster.getDirection())) {
            this.cleaningHamster.turnLeft();
        }
    }

    public void collectEachGrainOnEvenTile() {
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                this.cleaningHamster.pickGrain();
            }
            this.cleaningHamster.move();
        }
    }

    public void changeRowAndTurnAround() {
        this.turnToDirection(Direction.SOUTH);
        this.cleaningHamster.move();
        if (this.cleaningHamster.getLocation().getRow() == 2) {
            this.turnRight();
        } else {
            this.cleaningHamster.turnLeft();
        }
    }

    public void cleanCave () {
        for (int i = 0; i < 2; i++) {
            this.collectEachGrainOnEvenTile();
            this.changeRowAndTurnAround();
        }

        this.collectEachGrainOnEvenTile();

        while (!this.cleaningHamster.mouthEmpty()) {
            this.cleaningHamster.putGrain();
        }
    }
}
