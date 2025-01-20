package de.unistuttgart.iste.sqa.pse.sheet11.homework.settler;

abstract class Ressource {
    public final String name;
    public final Position position;
    public final ResourceType resourceType;

    public Ressource (final String name, final Position position, ResourceType resourceType) {
        this.name = name;
        this.position = position;
        this.resourceType = resourceType;
    }
}
