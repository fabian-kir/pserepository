package de.unistuttgart.iste.sqa.pse.sheet06.homework.painter.spiral;

import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * Describe the purpose of this class here.
 *
 * @author Fabian Kirschenmann, Mika Hepper
 * @version (a version number or a date)
 */
public class PainterPauleSpiralHamsterGame extends SimpleHamsterGame {

	/**
	 * Creates a new PainterPauleHamsterGame.<br>
	 * Do not modify!
	 */
	public PainterPauleSpiralHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/PainterPauleTerritory.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}

	@Override
	protected void run() {
		spiral();
	}

	/**
	 * makes paule turn right.
	 * @ensures: paule will look to his right.
	 */
	private void turnRight() {
		/*@
		  @loop_invariant: paule turns left each iteration
		  @loop_variant: loop ends after 3 iterations
		 */
		for (int i = 0; i<3; i++) {
			this.paule.turnLeft();
		}
	}

	/**
	 * paule walks in a L-Shape and lays down a grain on each tile. The length of the L-shape is given by the argument.
	 * @param pathLength: defines the length of the L-shape.
	 * @requires: paule looks at the corner.
	 * 			  The path towards the corner is at least pathLength tiles away.
	 * 			  The next wall, oppsite to the side where paule stands and the corner is located, is at least pathLength tiles away.
	 * 			  paule has at least (pathLength-1)*2 grains in his mouth.
	 *
	 * @ensures: paule looks in the oppsite direction.
	 * 			 along the L-shaped path, on each tile, except the first one, there will be +1 grain.
	 *
	 */
	private void walkCornerAndPutGrains(int pathLength) {
		/*@
		  @loop_invariant: each iteration i is increased by one, paule turns left once
		  @loop_variant: the loop executes twice.
		 */
		for (int i = 0; i<2; i++) {
			/*@
			  @loop_invariant: each iteration paule puts a grain down and makes a step forward, walkedSteps is increased by one.
			  @loop_variant: loop ends after pathLength iterations.
			 */
			for (int walkedSteps = 0; walkedSteps<pathLength; walkedSteps++) {
				this.paule.putGrain();
				this.paule.move();
			}
			this.turnRight();
		}
	}

	/**
	 * paule starts at the Outside of the Territory and walks in a Spiral, as he drops off a Grain on each Tile, until he reaches the Middle
	 *
	 * @requires paule has enough Grains in his mouth
	 * 			 The Size of the Territory is a Square
	 * @ensures On every tile paule walks over there is a Grain
	 * 			paule made a Spiral and is standing in the Middle of the Territory
	 * 			paules grainCount decreased by the steps he took
	 */
	private void spiral() {
		int pathLength = 0;

		/*@
		* @loop_invariant: paule puts a Grain down each iteration
		* @loop_variant: Loop ends when paule faces a wall
		 */
		while (this.paule.frontIsClear()) {
			this.paule.putGrain();
			this.paule.move();
			pathLength++;
		}

		this.turnRight();

		/*@
		* @loop_invariant: each iteration pathLength decreases by 2 and
		*  				   walkCornerAndPutGrains is called once.
		* @loop_variant: loop ends when pathLength was decreased to 0 or smaller.
		 */
		while (pathLength>0) {
			this.walkCornerAndPutGrains(pathLength);
			pathLength -= 2;
		}

		this.paule.putGrain();
		this.paule.write("LETS GOOOOOOOOO");
	}
}
