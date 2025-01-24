package de.unistuttgart.iste.sqa.pse.sheet11.homework.settler;

abstract class Ressource {
    private final String name;
    private final Position position;
    private final ResourceType resourceType;

    /**
     * Constructs a Ressource with the specified name and position
     * and gets the ressource type of the ressource
     *
     * @requires that neither the name nor the position is null
     * @param name the name of the ressource
     * @param position the position of the ressource
     */
    public Ressource (final String name, final Position position) {
        this.name = name;
        this.position = position;
        this.resourceType = getRessourceType();
    }

    /**
     * get the RessourceType of the Ressource
     *
     * @requires Ressource is not null
     * @return the ressource type of the ressource
     */
    public abstract ResourceType getRessourceType();

    /**
     * get the name of the ressource
     *
     * @requires the name of the ressource is not null
     * @return the name of the ressource
     */
    public String getName() {
        return name;
    }

    /**
     * get the position of the ressource
     *
     * @requires that the position is not null
     * @return the position of the ressource
     */
    public Position getPosition() {
        return position;
    }

}
