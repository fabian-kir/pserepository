package de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house;

import de.hamstersimulator.objectsfirst.datatypes.Location;

import java.util.HashSet;
import java.util.Set;

/**
 * A house in the habitat game.
 *
 * A house consists of a least one wall and up to one door per wall.
 *
 * @author (your name)
 *
 */
public final class House {
	private final HashSet<Location> allDoors = new HashSet<>();

	private final Set<HouseWall> walls;

	/**
	 * Get all the walls of the house.
	 * @return walls of the house.
	 */
	public Set<HouseWall> getWalls() {
		return walls;
	}

	/**
	 * Get all the doors of the house.
	 *
	 * @return doors of the house.
	 */
	public Set<Location> getDoors() {
		// this version will collect all doors when getDoors is called.
		HashSet<Location> allDoors = new HashSet<>();

		for (HouseWall wall : this.getWalls()) {
			try {
				allDoors.add(wall.getDoor());
			} catch (NoDoorException ignored) {};
		}

		return allDoors;
	}

	// 2. Möglichkeit
	public Set<Location> getDoors() {
		return this.allDoors;
	}

	/**
	 * Creates a new house with the specified walls.
	 *
	 * @param walls walls of the new house.
	 */
	public House(final Set<HouseWall> walls) {
		if (walls == null || walls.isEmpty()) {
			throw new IllegalArgumentException("A house must have at least one wall, but there are none.");
		}
		this.walls = walls;

		// Für den 2. Lösungsweg der Aufgabe f)
		for (HouseWall wall : walls) {
			try {
				this.allDoors.add(wall.getDoor());
			} catch (NoDoorException ignored) {};
		}
	}
}
