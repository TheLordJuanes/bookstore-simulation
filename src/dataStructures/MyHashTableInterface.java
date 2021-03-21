/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package dataStructures;

public interface MyHashTableInterface<K extends Number, V> {

	public void insert(K key, V value);
	// Pre: new item to be added.
	// Post: Inserts an item into a table in its proper sorted order according to the item's search key.

	public V search(K key);
	// Post: Retrieves an item with a given search key from a table.

	public boolean delete(K key);
	// Post: Deletes an item with a given search key from the table.

	public boolean isEmpty();
	// Pre: none.
	// Post: Returns true if the table is empty, otherwise returns false.
}