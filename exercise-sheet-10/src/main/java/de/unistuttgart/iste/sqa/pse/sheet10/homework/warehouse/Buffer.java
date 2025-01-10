package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.StationeryItem;

import java.util.Stack;

/**
 * Represents a buffer for temporary storage of items.
 *
 * @author your name
 */
public final class Buffer {

	Stack<StationeryItem> bufferedItems;

	// TODO add documentation here
	public Buffer() {
		bufferedItems = new Stack<>();
	}

	// TODO add documentation here
	public void bufferItem(final StationeryItem stationeryItem) {
		this.bufferedItems.push(stationeryItem);
	}

	// TODO add documentation here
	public StationeryItem releaseItem() {
		return this.bufferedItems.pop();
	}

	// TODO add documentation here
	public /*@ pure @*/ boolean isEmpty() {
		return this.bufferedItems.isEmpty();
	}
}
