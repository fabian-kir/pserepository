package de.unistuttgart.iste.sqa.pse.sheet07.presence.springcleaning;
import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.external.model.Territory;

public class SpringCleaning {
    Hamster cleaningHamster;

    enum CleaningMode {
        CLEAN_ODD,
        CLEAN_EVEN
    };
    CleaningMode cleaningMode;
    public SpringCleaning(Hamster cleaningHamster, CleaningMode cleaningMode) {
        this.cleaningHamster = cleaningHamster;
        this.cleaningMode = cleaningMode;
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
            if (i % 2 == 1) {
                this.cleaningHamster.pickGrain();
            }
            this.cleaningHamster.move();
        }
        this.cleaningHamster.pickGrain();
    }

    public void collectEachGrainOnOddTile() {
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
        switch (cleaningMode) {
            case CLEAN_EVEN:

                this.collectEachGrainOnEvenTile();
                this.changeRowAndTurnAround();
                this.collectEachGrainOnOddTile();
                this.changeRowAndTurnAround();
                this.collectEachGrainOnEvenTile();

                while (!this.cleaningHamster.mouthEmpty()) {
                     this.cleaningHamster.putGrain();
                }
                break;
            case CLEAN_ODD:

                this.collectEachGrainOnOddTile();
                this.changeRowAndTurnAround();
                this.collectEachGrainOnEvenTile();
                this.changeRowAndTurnAround();
                this.collectEachGrainOnOddTile();

                while (!this.cleaningHamster.mouthEmpty()) {
                    this.cleaningHamster.putGrain();
                }
                break;
        }
    }
}
