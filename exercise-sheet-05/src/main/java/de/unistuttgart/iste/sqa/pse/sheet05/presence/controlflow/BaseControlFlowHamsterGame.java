package de.unistuttgart.iste.sqa.pse.sheet05.presence.controlflow;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * A new HamsterGame to try out some control flow structures.
 *
 * @author (your name)
 * @version (version number or date)
 */
public abstract class BaseControlFlowHamsterGame extends SimpleHamsterGame {

	/**
	 * Constructor for the BaseControlFlowHamsterGame class.
	 * Do not modify!
	 *
	 * @param territoryFile file-path to the .ter file specifying the game territory
	 */
	public BaseControlFlowHamsterGame(final String territoryFile) {
		this.loadTerritoryFromResourceFile(territoryFile);
		this.displayInNewGameWindow();
		game.startGame();
	}

	/**
	 * Move paule to the next wall.
	 *
	 * Ensures that paule's front is not clear.
	 *
	 * This is an example for an operation with pre- and postconditions and
	 * loop(in)variants in natural language.
	 */
	protected void moveToWall() {
		/*@
		@ loop_invariant paule moved number of already executed loop iterations steps.
		@ decreasing number of tiles between paule and the next wall.
		@*/
		while (paule.frontIsClear()) {
			paule.move();
		}
	}

	/*
	 * Please implement your solutions into the following methods.
	 * Remember to add the appropriate JavaDoc documentation and pre-post conditions for each operation
	 * as well as the variants and loop invariants for any loops that are part of your implementation.
	 */

	/**
	 * Pick Grain if Grain is available
	 *
	 * @requiers paule is standing on any tile.
	 * @ensures if a grain was available paule's Grain Count increased and the grain is removed from the tile.
	 */
	protected void pickGrainIfAvailable() {
		if (paule.grainAvailable()) {
			paule.pickGrain();
		}
	}

	/**
	 * Paule picks all Grains on current Tile
	 *
	 * @requiers paule is standing on any tile.
	 * @ensures there are no grains left on the tile.
	 */
	protected void pickAllGrains() {
		/*@
		@ loop_invariant Each loop repetition the number of Grains on the tile decreases and the amount of Grains
		@ decreasing loop ends when no grains on the tile anymore
		 */
		while (paule.grainAvailable()) {
			paule.pickGrain();
		}
	}

	/**
	 * Paule will move forward for as long as specified
	 * @param times: specifies how many tiles paul will move
	 *
	 * @requires: The next 'times' tiles are no walls so the straight path is free
	 * @ensures: Paule will have 'times' tiles walked in the direction he's facing
	 */
	protected void multiMove(Integer times) {
		/*
		@ loop_invariant paule walked as many steps in the direction he's looking as specified by 'stepsWalked'
		@ decreasing Loop ends when "stepsWalked" is equal to argument "times"
		 */
		for(int stepsWalked = 0;  stepsWalked < times; stepsWalked++) {
			paule.move();
		}
	}

	/**
	 * Paule picks Grain if available, if not and he is not standing in front of a Wall
	 * paule moves one tile forward.
	 *
	 * @requiers paule is standing on any tile
	 * @ensures if possible, the grain count of the start tile is decresed by one
	 */
	protected void pickGrainOrMove() {
		if (paule.grainAvailable()) {
			paule.pickGrain();
		}
		else if (paule.frontIsClear()) {
			paule.move();
		}
		else {}
	}

	/**
	 * @requires There's at least one grain on the tile where the hamster stands
	 * @ensures all grains will be picked up on the tile where the hamster stands and the hamsters grainCount increases accordingly
	 */
	protected void pickAllGrainsOnNonEmptyTile() {
		/*@
		@ loop_invariant each iteration paule picked up one grain
		@ decreasing loop ends when there are no more grains available
		 */
		do {
			paule.pickGrain();
		} while (paule.grainAvailable());
	}

	/**
	 * the hamster puts given number of grains on the tile
	 *
	 * @param amountOfGrains declares the amount of grains that should be put by paule. amountOfGrains >= 0.
	 * @requires the hamster has at least 'amountOfGrains' grains in his mouth
	 * @ensures the grainCount of the tile that the hamster stands on is increased by 'amountOfGrains'
	 */
	protected void putGrains(Integer amountOfGrains) {
		/*@
		@ loop_invariant with each iteration grainsPutDown increases, the amount of grains in the hamsters mouth decreases, the amount of grains on the ti
		@ decreasing loop ends when grainsPutDown is equal to amountOfGrains 
		 */
		for (int grainsPutDown = 0; grainsPutDown < amountOfGrains; grainsPutDown++) {
			paule.putGrain();
		}
	}


	/**
	 * @ensures: paule has no grains in his mouth afterwards, the new grainCount on the tile is the old grainCount of paule
	 */
	protected void emptyMouth() {
		/*@
		@ loop_invariant with each iteration the grain count on the tile increases and the grainCount of paule decreases
		@ decreasing loop ends when paules mouth is Empty
		 */
		while (!paule.mouthEmpty()) {
			paule.putGrain();
		}
	}

	protected void cleanTerritory() {

		// sorg dafür dass paule nach EAST schaut
		// danach laufen wir gerade aus und sammeln grains ein falls möglich bis eine wand kommt
		// dann dre
		
		// 1. Paule nach Süden blicken lassen
		while(paule.getDirection() != Direction.SOUTH) {
			paule.turnLeft();
		}

		// final Location startLocation = paule.getLocation();
		final String startLocation = paule.getLocation().toString();

		while(paule.grainAvailable()) {
			paule.pickGrain();
		}
		paule.move();
		
		do {
			if (paule.grainAvailable()) {
				paule.pickGrain();
			} else if (paule.frontIsClear()) {
				paule.move();
			} else {
				paule.turnLeft();
			}
			// } while (!startLocation.equals(paule.getLocation()));
		} while (!startLocation.equals(paule.getLocation().toString()));
	}
}

