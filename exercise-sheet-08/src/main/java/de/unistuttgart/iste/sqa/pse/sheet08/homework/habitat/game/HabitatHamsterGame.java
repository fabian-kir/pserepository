package de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.game;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.TerritoryBuilder;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;
import de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house.House;
import de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house.HouseBuilder;
import de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house.HouseWall;
import de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house.TooManyDoorsException;
import org.ietf.jgss.ChannelBinding;

/**
 * The habitat hamster game.
 */
public final class HabitatHamsterGame extends SimpleHamsterGame {

	private House house;

	public HabitatHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/habitatTerritory.ter");

		TerritoryBuilder territoryBuilder = game.getNewTerritoryBuilder();

		HouseBuilder houseBuilder = new HouseBuilder(territoryBuilder, game.getTerritory());

		houseBuilder.withWall(
				new HouseWall(new Location(1, 1), new Location(1, 10))
		);


		Location doorLocation = new Location(7, 5);
		HouseWall newWall = new HouseWall(new Location(7, 4), new Location(7, 9));
		try {
			newWall.addDoor(doorLocation);
		} catch (TooManyDoorsException e) {
			System.out.println("TODO handle excep");
			// throw new TooManyDoorsException("You cannot add two doors into the same wall");
			// TODO Joy fragen wie ich mit dieser Exception umgehe. Sie sollte nie auftreten aber trotzdem muss ich sie ja catchen. Darf ich sie ignorieren?
		}
		houseBuilder.withWall(newWall);


		doorLocation = new Location(4,10);
		newWall = new HouseWall(new Location(2,10), new Location(7,10));
		try {
			newWall.addDoor(doorLocation);
		} catch (TooManyDoorsException e) {
			System.out.println("TODO handle excep");
			// throw new TooManyDoorsException("You cannot add two doors into the same wall");
			// TODO Joy fragen wie ich mit dieser Exception umgehe. Sie sollte nie auftreten aber trotzdem muss ich sie ja catchen. Darf ich sie ignorieren?
		}
		houseBuilder.withWall(newWall);


		houseBuilder.withWall(
				new HouseWall(new Location(6, 1), new Location(6, 4))
		);
		houseBuilder.withWall(
				new HouseWall(new Location(2, 1), new Location(5, 1))
		);


		House house = houseBuilder.build();


		// ...and here. Do NOT put any code after here.

		game.initialize(territoryBuilder);
		game.startGame();

		this.displayInNewGameWindow();
	}

	/**
	 * Paule moves counterclockwise around his house.
	 * <p>
	 * While doing that he checks whether his house is build as described in Figure
	 * 3 of the exercise sheet.
	 */
	@Override
	protected void run() {
		checkWesternHouseWall();
		checkSouthernHouseWall();
		checkEasternHouseWall();
		checkNorthernHouseWall();
	}

	/**
	 * Paule checks whether the northern house wall of the house is build as
	 * described in Figure 3 of the exercise sheet.
	 * <p>
	 * Requires that paule is at location (1, 11).
	 */
	private void checkNorthernHouseWall() {
		/*assert paule.getLocation().equals(new Location(1, 11));
		turnTowards(Direction.WEST);
		checkWallSegments(3);
		turnRight();
		paule.move();
		paule.turnLeft();
		checkWallSegments(4);
		paule.move();
		checkDoor();
		checkWallSegments(2);
		paule.move();
		*/
		assert paule.getLocation().equals(new Location(1, 11));
		turnTowards(Direction.WEST);
		checkWallSegments(10);
		paule.move();
		paule.write("Done");
	}

	/**
	 * Paule checks whether the eastern house wall of the house is build as
	 * described in Figure 3 of the exercise sheet.
	 * <p>
	 * Requires that paule is at location (7, 11).
	 */
	private void checkEasternHouseWall() {
		/*assert paule.getLocation().equals(new Location(7, 11));
		turnTowards(Direction.NORTH);
		checkWallSegments(2);
		paule.move();
		checkDoor();
		checkWallSegments(2);
		paule.move();
		*/
		assert paule.getLocation().equals(new Location(8, 11));
		turnTowards(Direction.NORTH);
		checkWallSegments(2);
		paule.move();
		checkDoor();
		checkWallSegments(4);
		paule.move();
	}

	/**
	 * Paule checks whether the southern house wall of the house is build as
	 * described in Figure 3 of the exercise sheet.
	 * <p>
	 * Requires that paule is at location (7, 0).
	 */
	private void checkSouthernHouseWall() {
		/*assert paule.getLocation().equals(new Location(7, 0));
		turnTowards(Direction.EAST);
		checkWallSegments(10);
		paule.move();
		 */
		assert paule.getLocation().equals(new Location(7, 0));
		turnTowards(Direction.EAST);
		checkWallSegments(3);
		this.turnRight();
		paule.move();
		paule.turnLeft();
		checkWallSegments(1);
		paule.move();
		checkDoor();
		checkWallSegments(5);
		paule.move();
	}

	/**
	 * Checks whether the western house wall of the house is build as described in
	 * Figure 3 of the exercise sheet.
	 * <p>
	 * Requires that paule is at the territory's origin.
	 */
	private void checkWesternHouseWall() {
		/*assert paule.getLocation().equals(new Location(0, 0));
		turnTowards(Direction.SOUTH);
		checkWallSegments(6);
		paule.move();
		 */
		assert paule.getLocation().equals(new Location(0, 0));
		turnTowards(Direction.SOUTH);
		checkWallSegments(6);
		paule.move();
	}

	/**
	 * Paule turns towards the given direction.
	 * <p>
	 * Ensures that paule looks into the given direction.
	 *
	 * @param direction direction to turn towards.
	 */
	private void turnTowards(final Direction direction) {
		/*@
		@ loop_invariant paule turned once for each already executed loop iteration
		@ decreasing number of turns, until paule faces his initial direction again
		@*/
		while (paule.getDirection() != direction) {
			paule.turnLeft();
		}
	}

	/**
	 * Paule turns to his right.
	 */
	private void turnRight() {
		paule.turnLeft();
		paule.turnLeft();
		paule.turnLeft();
	}

	/**
	 * Paule checks whether he's standing next to a door.
	 * <p>
	 * Ensures, that paule looks into the initial direction.
	 */
	private void checkDoor() {
		paule.turnLeft();
		if (!paule.frontIsClear()) {
			paule.write(String.format(
					"My house is all wrong! I wanted a Door at Location (%d, %d)!",
					paule.getLocation().getRow(), paule.getLocation().getColumn()));
		}
		turnRight();
	}

	/**
	 * Paule checks whether there is a {@code HouseWall} segment of the given length
	 * to his left.
	 * <p>
	 * Requires, that {@code lengthOfSegment} tiles in front of paule are clear.
	 *
	 * @param lengthOfSegment length of the wall segment to check.
	 */
	private void checkWallSegments(final int lengthOfSegment) {
		/*@
		@ loop_invariant paule moved i steps
		@ decreasing lengthOfSegment - i
		@*/
		for (int i = 0; i < lengthOfSegment; i++) {
			paule.move();
			paule.turnLeft();
			if (paule.frontIsClear()) {
				paule.write(String.format(
						"My house is wrong! I wanted a Wall at Location (%d, %d)!",
						paule.getLocation().getRow(), paule.getLocation().getColumn()));
			}
			turnRight();
		}
	}
}
