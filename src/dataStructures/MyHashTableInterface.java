/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 23th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package dataStructures;

public interface MyHashTableInterface<K extends Number, V> {

	/**
	 * Name: insert
	 * inserts the Object value in the hashtable with the reference key, if two keys hash to the same slot on the table, adds as nextNode of the last node in that slot
	 * @param key an object of type <K> to be used as key to reference the value within the table
	 * @param value an object of type <V> to be stored in within the table
	 */
	public void insert(K key, V value);

	/**
	 * Name: search
	 * searches for a value with a matching key
	 * @param key an object of type <K>
	 * @return if the key matches one of a value in the table, returns that object of type <V>, else returns null
	 */
	public V search(K key);

	/**
	 * Name: delete
	 * deletes a Node from the if the key matches
	 * @param key an object of type <K>
	 * @return true if the object was successfully removed, false otherwise
	 */
	public boolean delete(K key);

	/**
	 * Name: isEmpty
	 * @return true if there are no values stored in the table, false otherwise
	 */
	public boolean isEmpty();

}