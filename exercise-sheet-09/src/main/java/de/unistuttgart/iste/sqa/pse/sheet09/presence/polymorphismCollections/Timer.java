package de.unistuttgart.iste.sqa.pse.sheet09.presence.polymorphismCollections;

import static java.lang.Math.pow;

enum State {
	READY,
	RUNNING,
	STOPPED
}

/**
 * A class implementing a timer or a stop watch.
 *
 * @author Steffen Becker, Sophie Stieß
 */
public class Timer {

	private long nanosecondsAtStart;
	private long nanosecondsAtStop;
	private State timerState = State.READY;

	/**
	 * When the timer is ready, start measuring the time.
	 *
	 * Requires that {@code timerState == State.READY}, ensures that
	 * {@code timerState == State.RUNNING} and {@code nanosecondsAtStart} is the current time according to the JVM.
	 *
	 */
	public void start() {
		if (timerState != State.READY) {
			throw new IllegalStateException("Timer not ready");
		}
		timerState = State.RUNNING;
		nanosecondsAtStart = System.nanoTime();
	}

	/**
	 * When the timer is running, stop the measurement.
	 *
	 * Requires that {@code timerState == State.RUNNING}, ensures that
	 * {@code timerState == State.STOPPED} and that {@code nanosecondsAtStop} is the current time according to the JVM.
	 * Also ensures that {@code nanosecondsAtStart <= nanosecondsAtStop}.
	 *
	 * Once the timer is stopped, the measurement can be printed with {@link Timer#printResult()}.
	 */
	public void stop() {
		if (timerState != State.RUNNING) {
			throw new IllegalStateException("Timer not running");
		}
		nanosecondsAtStop = System.nanoTime();
		timerState = State.STOPPED;
	}

	/**
	 * Reset a stopped timer.
	 *
	 * Requires that {@code timerState == State.STOPPED}, ensures that
	 * {@code timerState == State.READY} and both {@code nanosecondsAtStart} and {@code nanosecondsAtStop} are zero.
	 */
	public void reset() {
		if (timerState != State.STOPPED) {
			throw new IllegalStateException("Timer not stopped");
		}
		nanosecondsAtStart = 0;
		nanosecondsAtStop = 0;
		timerState = State.READY;
	}

	/**
	 *
	 * Requires that {@code timerState == State.STOPPED}.
	 *
	 * @return the measurement taken in case the timer has been stopped.
	 */
	public long getResultInNanoseconds() {
		if (timerState != State.STOPPED) {
			throw new IllegalStateException("Timer not stopped");
		}
		return nanosecondsAtStop - nanosecondsAtStart;
	}

	/**
	 * Print the measured time to the console in Microseconds
	 */
	public void printResult() {
		System.out.format(
				"The timer recorded %dµs (%.4fms)\n",
				Math.round(getResultInNanoseconds() / pow(10, 3)), getResultInNanoseconds() / pow(10, 6));
	}
}
