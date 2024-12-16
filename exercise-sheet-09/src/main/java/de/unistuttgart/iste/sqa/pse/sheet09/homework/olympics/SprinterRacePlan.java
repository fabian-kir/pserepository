package de.unistuttgart.iste.sqa.pse.sheet09.homework.olympics;

/**
 * Makes the hamster sprint, if enough energy points are available,
 * else the hamster will run steadily, if possible.
 * Lastly, if no energy points are available, the hamster will run slowly.
 *
 * @ensures the hamster runs according to its energy reservers, and takes at least one step forward,
 * 			but up to 3 steps.
 *
 * @author Mika Hepper, Fabian Kirschenmann
 */
public final class SprinterRacePlan implements RacePlan {

	@Override
	public void nextStep(final RunnerHamster hamster) {
		// put your code for task (c) here
		if (hamster.getEnergyRemaining() >= 3) {
			hamster.runHard();
		}
		else if (hamster.getEnergyRemaining() >= 1) {
			hamster.runSteadily();
		}
		else {hamster.runSlowly();}
	}
}
