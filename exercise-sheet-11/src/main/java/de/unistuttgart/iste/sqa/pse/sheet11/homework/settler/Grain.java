package de.unistuttgart.iste.sqa.pse.sheet11.homework.settler;

public class Grain extends Ressource{
    private static final ResourceType RESSOURCE_TYPE = new ResourceType("Grain");

    public Grain(String name, Position position) {
        super(name, position);
    }

    @Override
    public ResourceType getRessourceType() {
        return RESSOURCE_TYPE;
    }
}