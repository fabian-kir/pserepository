package de.unistuttgart.iste.sqa.pse.sheet09.homework.olympics;

/**
 * Makes the hamster run steadily, if enough energy points are available,
 * else the hamster will run slows.
 *
 * @ensures The hamster will move at least one step forward, but up to 2 steps.
 *
 * @author Mika Hepper, Fabian Kirschenmann
 */
public final class RunSteadilyRacePlan implements RacePlan {
	@Override
	public void nextStep(final RunnerHamster hamster) {
		// put your code for task (c) here
		if (hamster.getEnergyRemaining() >= 1) {
			hamster.runSteadily();
		} else {
			hamster.runSlowly();
		}
	}
}
