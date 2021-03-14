package model;

import dataStructures.MyHashTable;

public class Shelf<K extends Number, V> extends MyHashTable<K, V> {

    // -----------------------------------------------------------------
	// Attributes
    // -----------------------------------------------------------------

    private final String identifier;

    // -----------------------------------------------------------------
	// Methods
    // -----------------------------------------------------------------

    public Shelf(String identifier) {
        super();
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}