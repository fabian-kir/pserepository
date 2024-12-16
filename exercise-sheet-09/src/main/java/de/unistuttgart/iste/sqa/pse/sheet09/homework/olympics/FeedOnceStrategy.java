package de.unistuttgart.iste.sqa.pse.sheet09.homework.olympics;

/**
 * When this strategy is used,
 * the Hamster will Eat Once at the FeedingStation to regain Energy and then continue the Race
 *
 * @class_variant stationFeedCount indicates, how often the hamster ate a the station he's at.
 * @class_invariant: stationFeedCount is 0 or 1.
 *
 * @author Mika Hepper, Fabian Kirschenmann
 */
public final class FeedOnceStrategy implements FeedingStrategy {
	// if required, put attributes for task (d) here
	int stationFeedCount = 0;

	/**
	 * @requires The hamster is at a Feeding Station and there are grains available to pick.
	 * @ensures Will switch between returning true and false
	 * @return a boolean which specifies wether the hamster is supposed to eat or not.
	 */
	@Override
	public boolean isFeedingRequired() {
		if (stationFeedCount < 1) {
			stationFeedCount++;
			return true;
		} else {
			stationFeedCount = 0;
			return false;
		}

	}
}
