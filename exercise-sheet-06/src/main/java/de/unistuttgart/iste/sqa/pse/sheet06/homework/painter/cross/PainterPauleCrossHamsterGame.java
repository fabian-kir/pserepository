package de.unistuttgart.iste.sqa.pse.sheet06.homework.painter.cross;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * Describe the purpose of this class here.
 *
 * @author Mika Hepper, Fabian Kirschenmann
 * @version 25112024
 */
public class PainterPauleCrossHamsterGame extends SimpleHamsterGame {

	/**
	 * Creates a new PainterPauleHamsterGame.<br>
	 * Do not modify!
	 */
	public PainterPauleCrossHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/PainterPauleTerritory.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}

	@Override
	protected void run() {
		cross();
	}

	/**
	 * Makes paule move diagonally across the territory and drop a grain on each diagonal tile, until he arrives in
	 * the opposite corner.
	 * @requires: territory must be a square of size at least 3x3 and of uneven tile lengths (3x3, 5x5, 7x7, etc.)
	 * 			  paule must have enough grains in its mouth.
	 * 			  paule must start in a West-corner of the territory.
	 * 			  paule has to look in a certain direction depending on which corner he's starting from.
	 * 			  	starting North-West -> looking South
	 * 			  	starting South-West -> looking North
	 * @ensures:  paule will lay down a grain on each tile which is on one of the squares diagonals, except the first one.
	 * 			  paule will look in the direction as in the beginning.
	 */
	private void walkDiagonalAndPutGrain() {
		/*@
		 * @loop_invariant: paule will drop one grain and move 1 tile diagonally each iteration. The grainCount will decrease by one each iteration.
		 * @loop_variant: loop will end when paule is facing a wall after the diagonal step.
		 */
		do {
			/*@s
			  @loop_invariant: i will increase by one each time paule turns left.
			  @loop_variant: loop will end after paule turned 3 times.
			 */
			for (int i = 0; i<3; i++) {
				this.paule.turnLeft();
			}
			this.paule.move();
			this.paule.turnLeft();
			this.paule.move();
			this.paule.putGrain();
		} while (this.paule.frontIsClear());
	}

	/**
	 * Turns paule so that he's facing the given direction afterwards.
	 * @param direction: The direction paule should face afterwards
	 *
	 * @ensures paule is facing the direction given by the argument afterwards.
	 */
	private void turnToDirection(Direction direction) {
		/*@
		  @loop_invariant: paule makes a left-turn each iteration
		  @loop_variant: loop ends when paule faces the direction given by the argument 'direction'
		 */
		while (this.paule.getDirection() != direction) {
			this.paule.turnLeft();
		}
	}

	/**
	 * Makes paule lay down Grains on a square territory so that they form a cross.
	 * @requires territory must be a square with an uneven tile size >= 3 (3x3, 5x5, 7x7, ...)
	 *			 paule must have more than territorySize*2 grains in his mouth. (territorySize is the height of the territory in tiles)
	 *			 paule must stand in the south-western corner.
	 *			 There must be no grains on the territory.
	 *
	 * @ensures: paule will end in the south-eastern corner.
	 * 			 On the territory-diagonals will be grains.
	 * 			 paules grainCount will decrease by 2*territorySize
	 *
	 */
	private void cross() {
		this.paule.putGrain();
		this.turnToDirection(Direction.NORTH);

		this.walkDiagonalAndPutGrain();
		this.turnToDirection(Direction.WEST);

		/*@
		  @loop_invariant: paule makes a step forward each iteration
		  @loop_variant: loop ends when paule faces a wall.
		 */
		while (this.paule.frontIsClear()) {
			this.paule.move();
		}

		this.paule.putGrain();
		this.turnToDirection(Direction.EAST);
		this.walkDiagonalAndPutGrain();
		this.paule.write("DONE");
	}
}
