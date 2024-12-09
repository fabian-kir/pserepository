package de.unistuttgart.iste.sqa.pse.sheet07.homework.exceptions;

import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * A SimpleHamsterGame with exceptions
 *
 * @author Mika Hepper, Fabian Kirschenmann
 * @version 031224
 */
public class LazyHamsterGame extends SimpleHamsterGame {

	/**
	 * This constructor is used for loading a territory for the game and for displaying it.
	 * Do not modify.
	 */
	public LazyHamsterGame(final String territoryFile) {
		this.loadTerritoryFromResourceFile(territoryFile);
		this.displayInNewGameWindow();
		game.startGame();
	}

	/**
	 * Do not modify this operation.
	 */
	@Override
	protected void run() {
		moveMultipleSteps(10);
	}

	/**
	 * When calling this, paule has a 75% chance of moving, otherwise this will throw an Exception
	 * @requires  paule is not standing in front of a wall
	 * @ensures either paule takes one step forward or this will throw an exception
	 * @throws TooLazyException
	 */
	public void tryToMove() throws TooLazyException{
		if (Math.random() <= 0.75f) {
			paule.move();
		} else {
			throw new TooLazyException();
		}
	}

	/**
	 * paule will check if he is Caged, if the program will throw an Exception
	 * paule will make numberOfSteps moves into any available direction, but prefers forward, left, then backwards, last right.
	 * @requires numberOfSteps > 0, paule is not caged - at least in one direction theres no wall.
	 * @ensures moves numberOfSteps
	 * @throws NoWayToGoException if paule has no way to go and is trapped (in all directions there's a wall)
 	 */


	public void moveMultipleSteps(int numberOfSteps) throws NoWayToGoException {
		boolean hasMoved = false;

		if (isCaged()) {
			throw new NoWayToGoException();
		}

		for (int i = 0; i < numberOfSteps; i++) {
			while (!paule.frontIsClear()) {
				paule.turnLeft();
			}

			/* @Joy: Das ist doch viel schönerer Code. Wäre das Stilistisch unkorrekt wegen der while-true-break?
			while (true) {
				try {
					tryToMove();
					break;
				} catch (TooLazyException e) {
					paule.write("SENPAI I BELIEVE IN U uWu 😫");
				};
			}
			 */

			do {
				try {
					tryToMove();
					hasMoved = true;
				} catch (TooLazyException e) {
					paule.write("SENPAI I BELIEVE IN U uWu 😫");
				};

			} while(!hasMoved);
			// hasMoved = false;
		}
	}

	/**
	 * Checks if paule is caged, meaning wether on all 4 tiles next to paule is a wall.
	 * @ensures paule will turn around 4 times
	 * @return true if on all 4 tiles next to paules tile is a wall, else false
	 */
	public boolean isCaged() {
		boolean caged = true;

		/*@
		  @loop_invariant: each iteration i is increased by one and paule turns to the left once
		  				   sets 'caged' to true if there's a wall in front of paule
		  @loop_variant: loop ends after 4 iterations
		 */
		for (int i = 0; i<4; i++) {
			if (paule.frontIsClear()) {
				caged = false;
			}
			paule.turnLeft();
		}
		game.getTerritory().getTerritorySize().getColumnCount();
		return caged;
	}
}
