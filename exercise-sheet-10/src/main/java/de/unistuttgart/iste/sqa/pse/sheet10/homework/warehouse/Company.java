package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Compass;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Pen;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Ruler;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.StationeryItem;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

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
	private Set<Customer> customers;
	// TODO: Add data structure for exercise part (i) here.

	// TODO add documentation here.
	public Company() {
		orderBuffer = new Buffer();
		// TODO: implement exercises part (i) here.
		itemStorageRack = new StorageRack(75); // TODO delete this line if necessary
	}

	// TODO add documentation here.
	public void storeInStorageRack(final StationeryItem stationeryItem) {
		try {
			itemStorageRack.addItem(stationeryItem);
		} catch (OutOfStorageException e) {
			System.out.format("Ignoring item: %s because the storage is full.", stationeryItem);
		}
	}

	// TODO add documentation here.
	public void processIncomingOrder(final Identifier identifier, final Customer customer) {
		Optional<StationeryItem> orderedItem = this.itemStorageRack.getItemFromIdentifier(identifier);
		if (orderedItem.isPresent()) {
			this.orderBuffer.bufferItem(orderedItem.get());
			this.handleCustomerMarketing(customer);
		} else {
			System.out.format("Ignoring an order because theres no Item with the Identifier %s in storage.", identifier);
			// TODO: This should definitely throw an Exception in any real world application because we just forget about an order!!!
		}
	}

	public void handleCustomerMarketing(Customer customer) {
		if (!this.customers.contains(customer)) {
			this.customers.add(customer);
			StationeryItem bonusItem = this.getBonusItem();
			this.orderBuffer.bufferItem(bonusItem);
		}
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
