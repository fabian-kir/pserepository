package de.unistuttgart.iste.sqa.pse.sheet11.homework.settler;

public class Grain extends Ressource{
    private static final ResourceType RESSOURCE_TYPE = new ResourceType("Grain");

    /**
     * Constructs a Grain with the specified name and position
     *
     * @requires that neither the name nor the position is null
     * @param name the name of the grain
     * @param position the position of the grain
     */
    public Grain(String name, Position position) {
        super(name, position);
    }

    /**
     * get the ressource type grain
     *
     * @requires that the ressource type is not null
     * @return the ressource type grain
     */
    @Override
    public ResourceType getRessourceType() {
        return RESSOURCE_TYPE;
    }
}

