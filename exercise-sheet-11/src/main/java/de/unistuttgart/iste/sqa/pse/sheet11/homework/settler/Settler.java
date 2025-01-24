package de.unistuttgart.iste.sqa.pse.sheet11.homework.settler;

abstract class Settler {
    private final String name;
    private final Position position;

    /**
     * Constructs a Settler with specified name and position
     * Requires that neither name nor position is null
     *
     * @param name the name of the settler
     * @param position the position of the settler
     */
    public Settler(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    /**
     * returns the name of the settler
     *
     * @requires that the name of the settler is not null
     * @return the name of the settler
     */
    public String getName() {
        return name;
    }

    /**
     * returns the position of the settler
     *
     * @requires that the position of the settler is not null
     * @return the position of the settler
     */
    public Position getPosition() {
        return position;
    }

    /**
     * defines the settling behavior of the settler
     */
    public void settle() {
        //TODO
    }
}

