package de.unistuttgart.iste.sqa.pse.sheet11.homework.settler;

import java.util.Optional;

public class Soldier extends Settler{
    private Optional<Barracks> home;

    public Soldier(String name, Position position) {
        super(name, position);

        this.home = Optional.empty();
    }

    public void fightEnemy(Settler enemy) {
        // TODO
    }

    public void setHome(Barracks home) {
        this.home = Optional.of(home);
    }

    public Optional<Barracks> getHome() {
        return home;
    }
}
