/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
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

    /**
	 * Name: Shelf
	 * Constructor method of a shelf.
	 * @param identifier - shelf's identifier - identifier = String, id != null, id != ""
	*/
    public Shelf(String identifier) {
        super();
        this.identifier = identifier;
    }

    /**
	 * Name: getIdentifier
	 * Method used to get the shelf's identifier.
	 * @return A String representing the shelf's identifier.
	*/
    public String getIdentifier() {
        return identifier;
    }
}