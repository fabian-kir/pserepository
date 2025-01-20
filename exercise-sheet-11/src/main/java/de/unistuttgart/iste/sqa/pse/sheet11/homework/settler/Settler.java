package de.unistuttgart.iste.sqa.pse.sheet11.homework.settler;

abstract class Settler {
    public final String name;
    public final Position position;

    public Settler(String name, Position position) {
        this.name = name;
        this.position = position;
    }
}

