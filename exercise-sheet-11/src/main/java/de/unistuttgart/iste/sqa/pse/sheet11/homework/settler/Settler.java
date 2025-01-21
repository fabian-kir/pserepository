package de.unistuttgart.iste.sqa.pse.sheet11.homework.settler;

abstract class Settler {
    private final String name;
    private final Position position;

    public Settler(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}

