package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.StationeryItem;

import java.util.*;

/**
 * Represents a warehouse that can hold a fixed number of items.
 * The number of holdable items is defined by the capacity of the storage rack.
 *
 * @author your name
 */
public final class StorageRack {
	// classinvariants:
	// capacity > 0;
	// numberOfItems >= 0;
	// numberOfItems <= capacity;

	private final int capacity;
	private int numberOfItems;

	private List<Optional<StationeryItem>> storage;  // TODO final or not?
	private Map<Identifier, Integer> identifierToStorageIndex;


	/**
	 * Creates a new storage rack with the given capacity.
	 *
	 * Ensures that the new rack is empty and has the given capacity.
	 *
	 * TODO add missing pre- and postconditions here.
	 *
	 * @param capacity capacity of the storage rack. Must be > 0.
	 *
	 * @throws IllegalArgumentException If capacity is less than 1.
	 */
	public StorageRack(final int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("A warehouse must have a minimum capacity of 1.");
		}
		this.capacity = capacity;
		numberOfItems = 0;

		storage = new ArrayList<>(capacity);
		for(int i = 0; i < capacity; i++) {
			storage.add(Optional.empty());
		}

		identifierToStorageIndex = new HashMap<>(capacity);
	}

	// TODO add documentation here.
	public void addItem(final StationeryItem stationeryItem) throws OutOfStorageException {
		for (int i = 0; i < this.capacity; i++) {
			if (this.storage.get(i).isEmpty()) {
				this.storage.set(i, Optional.of(stationeryItem));

				this.identifierToStorageIndex.put(stationeryItem.getIdentifier(), i);
				numberOfItems++;

				break; // TODO überlegen ob der break hier Stilok ist weil er macht absolut Sinn an der Stelle
			}
		}
	}

	// TODO add documentation here.
	public void removeItem(final int compartmentNumber) {
		if (this.storage.get(compartmentNumber).isPresent()) {
			StationeryItem itemToRemove = this.storage.get(compartmentNumber).get();
			this.identifierToStorageIndex.remove(itemToRemove.getIdentifier());

			numberOfItems--;
		}

		this.storage.set(compartmentNumber, Optional.empty());
	}

	// TODO add documentation here.
	public Optional<StationeryItem> getItem(final int compartmentNumber) {
		Optional<StationeryItem> resItem = this.storage.get(compartmentNumber);
		this.removeItem(compartmentNumber);
		return resItem;
	}

	// TODO add documentation here.
	public Optional<Integer> getCompartmentNumberOf(final Identifier identifier) {
		if (this.identifierToStorageIndex.containsKey(identifier)) {
			return Optional.of(this.identifierToStorageIndex.get(identifier));
		} else {
			return Optional.empty();
		}
	}

	public Optional<StationeryItem> getItemFromIdentifier(Identifier identifier) {
		int compartmentNumber = this.identifierToStorageIndex.get(identifier);
		return this.getItem(compartmentNumber);
	}

	/**
	 * Get the capacity of this warehouse.
	 *
	 * @return The capacity of this warehouse.
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Get the number of items in this warehouse.
	 *
	 * @return The number of items in this warehouse.
	 */
	public int getNumberOfItems() {
		return this.numberOfItems;
	}
}
