package de.unistuttgart.iste.sqa.pse.sheet09.homework.olympics;

/**
 * Implements a strategy where the Hamster does not eat
 */
public final class FeedNeverStrategy implements FeedingStrategy {

	@Override
	public boolean isFeedingRequired() {
		return false;
	}
}
