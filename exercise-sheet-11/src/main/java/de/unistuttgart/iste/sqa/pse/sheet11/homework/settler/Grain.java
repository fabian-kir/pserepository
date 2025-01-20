package de.unistuttgart.iste.sqa.pse.sheet11.homework.settler;

public class Grain extends Ressource{

    public Grain(String name, Position position) {
        super(name, position, new ResourceType("Grain")); // TODO überdenken ob man da jedes mal einen neuen Resource Type erstellen sollte oder ob ma ndas mit Static löst
    }
}
