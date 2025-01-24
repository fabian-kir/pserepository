package de.unistuttgart.iste.sqa.pse.sheet11.homework.settler;

public class Soldier extends Settler{
    /**
     * Constructs a Soldier with the specified name and position
     *
     * @requires that neither the name nor the position is null
     * @param name the name of the soldier
     * @param position the position of the soldier
     */
    public Soldier(String name, Position position) {
        super(name, position);
    }

    /**
     * makes the soldier fight an enemy
     *
     * @requires that the enemy is not null
     * @param enemy the enemy the soldier fights
     */
    public void fightEnemy(Settler enemy) {
        // TODO
    }
}
