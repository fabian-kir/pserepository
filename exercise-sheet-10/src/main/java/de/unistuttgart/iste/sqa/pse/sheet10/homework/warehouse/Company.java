package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Compass;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Pen;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Ruler;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.StationeryItem;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

/**
 * Represents a company.
 *
 * A company stores items and processes orders.
 *
 * @author Mika Hepper, Fabian Kirschenmann
 */
public final class Company {

	private final StorageRack itemStorageRack;
	private final Buffer orderBuffer;
	private final Set<Customer> customers;

	/**
	 * initilizes the orderBuffer und itemStorageRack.
	 * The storage has a capacity of 75 items.
	 *
	 * @ensures object to be correctly initialzied
	 */
	public Company() {
		orderBuffer = new Buffer();
		itemStorageRack = new StorageRack(75);
		customers = new HashSet<>();
	}

	/**
	 * takes an Item stationaryItem and stores it in the storage rack.
	 *
	 * @requires there needs to be at least one empty place in storage (otherwise the item will be ignored)
	 * 				... in the real world this should throw an Exception
	 *
	 * @param stationeryItem The item to be stored.
	 *
	 * @ensures The item will be stored in the storageRack.
	 */
	public void storeInStorageRack(final StationeryItem stationeryItem) {
		try {
			itemStorageRack.addItem(stationeryItem);
		} catch (OutOfStorageException e) {
			System.out.format("Ignoring item: %s because the storage is full.", stationeryItem);
		}
	}

	/**
	 * Takes on order with the .Identfier given by identfier out of the storageRack and
	 * puts it on top the LIFO stack that will be processed for packaging.
	 * Will also call handleCustomerMarketing for further actions to the customer, if the item was found in itemStorageRack
	 *
	 * @requires There needs to be an item with the .Identifier that is given by identfier in the storage rack.
	 * 				(otherwise will be ignored, but should rather throw an Exception)
	 *
	 * @ensures The item will be removd from itemStorageRack and put ontop of orderBuffer
	 *
	 * @param identifier the id by which the item can be uniquily found in storageRack
	 * @param customer the customer that has ordered
	 */
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

	/**
	 * If the customer is a fist time customer, he/her will be added to the customer list
	 * customers and will receive a gift created by getBonusItem()
	 *
	 * @ensures customer receives a bonus item if he/her's a first-time customer
	 * @ensures customer will be added to customers-set.
	 *
	 * @param customer
	 */
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
