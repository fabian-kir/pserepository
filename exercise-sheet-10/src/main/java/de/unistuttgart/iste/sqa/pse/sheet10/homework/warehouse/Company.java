package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Compass;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Pen;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Ruler;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.StationeryItem;
import java.util.Optional;
import java.util.Random;

/**
 * Represents a company.
 *
 * A company stores items and processes orders.
 *
 * @author your name
 */
public final class Company {

	private final StorageRack itemStorageRack;
	private final Buffer orderBuffer;
	// TODO: Add data structure for exercise part (i) here.

	// TODO add documentation here.
	public Company() {
		orderBuffer = new Buffer();
		// TODO: implement exercises part (e) and (i) here.
		itemStorageRack = null; // TODO delete this line if necessary
	}

	// TODO add documentation here.
	public void storeInStorageRack(final StationeryItem stationeryItem) {
		// TODO: implement exercise part (e) here.
	}

	// TODO add documentation here.
	public void processIncomingOrder(final Identifier identifier, final Customer customer) {
		// TODO implement exercises part (h) and (i) here.
	}

	/**
	 * Generates a bonus item for marketing reasons.
	 *
	 * @return A non-null marketing bonus item.
	 */
	private StationeryItem getBonusItem() {

		switch ((new Random().nextInt(3))) {
			case 1:
				return new Compass(new Identifier(), "A marketing bonus item.");
			case 2:
				return new Ruler(new Identifier(), "A marketing bonus item.");
			default:
				return new Pen(new Identifier(), "A marketing bonus item.");
		}
	}

	/**
	 * If items are waiting for packaging, takes the next available item from the buffer and returns it.
	 *
	 * @return The next available item for packaging, or an empty Optional if there is none.
	 */
	public Optional<StationeryItem> takeItemForPackaging() {
		if (orderBuffer.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of(orderBuffer.releaseItem());
		}
	}
}
