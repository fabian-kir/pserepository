package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.StationeryItem;

import java.util.*;

/**
 * Represents a warehouse StorageRack that can hold a fixed number of items.
 * The number of holdable items is defined by the StorageRack's capacity.
 */
public final class StorageRack {
	private final int capacity;
	private int numberOfItems;
	private final List<Optional<StationeryItem>> storage;
	private final Map<Identifier, Integer> identifierToStorageIndex;

	/**
	 * Constructs a new StorageRack with a specified capacity.
	 *
	 * @param capacity The capacity of the storage rack, must be greater than 0.
	 * @throws IllegalArgumentException If the capacity is less than 1.
	 */
	public StorageRack(final int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("A warehouse must have a minimum capacity of 1.");
		}
		this.capacity = capacity;
		numberOfItems = 0;
		storage = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; i++) {
			storage.add(Optional.empty());
		}

		identifierToStorageIndex = new HashMap<>(capacity);
	}

	/**
	 * Adds an item to the least index available in the storage rack.
	 *
	 * @param stationeryItem The item to add.
	 * @throws OutOfStorageException If there is no available space to add the item.
	 */
	public void addItem(final StationeryItem stationeryItem) throws OutOfStorageException {
		if (this.numberOfItems >= this.capacity) {
			throw new OutOfStorageException("Storage is full.");
		}
		for (int i = 0; i < this.capacity; i++) {
			if (storage.get(i).isEmpty()) {
				storage.set(i, Optional.of(stationeryItem));
				identifierToStorageIndex.put(stationeryItem.getIdentifier(), i);
				numberOfItems++;
				break;
			}
		}
	}

	/**
	 * Removes an item from a specific compartment.
	 *
	 * @param compartmentNumber The index of the compartment to remove the item from.
	 */
	public void removeItem(final int compartmentNumber) {
		if (compartmentNumber < 0 || compartmentNumber >= capacity) {
			throw new IndexOutOfBoundsException("Invalid compartment number.");
		}
		if (storage.get(compartmentNumber).isPresent()) {
			StationeryItem itemToRemove = storage.get(compartmentNumber).get();
			identifierToStorageIndex.remove(itemToRemove.getIdentifier());
			numberOfItems--;
		}
		storage.set(compartmentNumber, Optional.empty());
	}

	/**
	 * Retrieves and removes an item from a specific compartment.
	 *
	 * @param compartmentNumber The compartment number to retrieve the item from.
	 * @return The item if available, otherwise returns an empty Optional.
	 */
	public Optional<StationeryItem> getItem(final int compartmentNumber) {
		Optional<StationeryItem> item = storage.get(compartmentNumber);
		removeItem(compartmentNumber);
		return item;
	}

	/**
	 * Gets the compartment number of an item identified by its identifier.
	 *
	 * @param identifier The identifier of the item.
	 * @return The optional containing the index of the compartment where the item is stored,
	 *         or an empty Optional if the item is not found.
	 */
	public Optional<Integer> getCompartmentNumberOf(final Identifier identifier) {
		return Optional.ofNullable(identifierToStorageIndex.get(identifier));
	}

	/**
	 * Retrieves and removes an item identified by its identifier.
	 *
	 * @param identifier The identifier of the item.
	 * @return The item if it exists and is removed, otherwise returns an empty Optional.
	 */
	public Optional<StationeryItem> getItemFromIdentifier(Identifier identifier) {
		return getCompartmentNumberOf(identifier)
				.flatMap(this::getItem); // Use flatMap to handle the Optional result.
	}

	/**
	 * Returns the capacity of the storage rack.
	 *
	 * @return The total capacity.
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Returns the number of items currently in the storage rack.
	 *
	 * @return The current number of items stored.
	 */
	public int getNumberOfItems() {
		return numberOfItems;
	}
}
