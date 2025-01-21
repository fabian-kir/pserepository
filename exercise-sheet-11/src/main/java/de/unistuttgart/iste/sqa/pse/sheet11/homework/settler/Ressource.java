package de.unistuttgart.iste.sqa.pse.sheet11.homework.settler;

abstract class Ressource {
    public final String name;
    public final Position position;
    private final ResourceType resourceType;

    public Ressource (final String name, final Position position) {
        this.name = name;
        this.position = position;
        this.resourceType = getRessourceType();
    }

    public abstract ResourceType getRessourceType();

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

}
