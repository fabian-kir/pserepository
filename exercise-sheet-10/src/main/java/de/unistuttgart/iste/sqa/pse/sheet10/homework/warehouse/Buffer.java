package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.StationeryItem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a buffer for temporary storage of items.
 * First item to go in is the first item to go out.
 *
 * @author Hepper, Kirschenmann
 */
public final class Buffer {

	Queue<StationeryItem> bufferedItems;

	public Buffer() {
		this.bufferedItems = new LinkedList<>();
	}

	/**
	 * Adds the item of type StationaryItem to buffer to the Queue.
	 *
	 * @param stationeryItem the item to add to the Buffer
	 */
	public void bufferItem(final StationeryItem stationeryItem) {
		this.bufferedItems.offer(stationeryItem);
	}

	/**
	 * Takes the oldest item in the queue and returns it.
	 *
	 * @requires there must be at least one buffered item <-> isEmpty() == false
	 *
	 * @return The next item in the buffer.
	 */
	public StationeryItem releaseItem() {
		return this.bufferedItems.poll();
	}

	/**
	 * @return true if there's no other item buffered, else false.
	 */
	public /*@ pure @*/ boolean isEmpty() {
		return this.bufferedItems.isEmpty();
	}
}
