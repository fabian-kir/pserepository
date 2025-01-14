package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.StationeryItem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a buffer for temporary storage of items.
 *
 * @author your name
 */
public final class Buffer {

	Queue<StationeryItem> bufferedItems;

	// TODO add documentation here
	public Buffer() {
		bufferedItems = new LinkedList<>();
	}

	// TODO add documentation here
	public void bufferItem(final StationeryItem stationeryItem) {
		this.bufferedItems.offer(stationeryItem);
	}

	// TODO add documentation here
	public StationeryItem releaseItem() {
		return this.bufferedItems.poll();
	}

	// TODO add documentation here
	public /*@ pure @*/ boolean isEmpty() {
		return this.bufferedItems.isEmpty();
	}
}
