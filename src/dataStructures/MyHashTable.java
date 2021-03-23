/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 23th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package dataStructures;

public class MyHashTable<K extends Number, V> implements MyHashTableInterface<K, V> {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	public static final int ARRAY_SIZE = 16;
	public static final double ARBITRARY_NUMBER = (Math.sqrt(5) - 1.0) / 2.0;

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	private HNode<K, V>[] nodes;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/**
	 * Name: MyHashTable
	 * Constructor method of a hash table.
	 * @param identifier - shelf's identifier - identifier = String, identifier != null, identifier != ""
	 * @param bookNum - number of book in a shelf - bookNum = int, bookNum != null, bookNum != 0
	*/
	@SuppressWarnings("unchecked")
	public MyHashTable() {
		nodes = (HNode<K, V>[]) new HNode[ARRAY_SIZE];
	}

	/**
	 * Name: insert
	 * inserts the Object value in the hashtable with the reference key, if two keys hash to the same slot on the table, adds as nextNode of the last node in that slot 
	 * @param key an object of type <K> to be used as key to reference the value within the table
	 * @param value an object of type <V> to be stored in within the table
	 */
	@Override
	public void insert(K key, V value) {
		int index = hash((int) key);
		HNode<K, V> node = new HNode<>(key, value);
		if (nodes[index] == null)
			nodes[index] = node;
		else {
			HNode<K, V> temp = nodes[index];
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
			node.setPrev(temp);
		}
	}

	/**
	 * Name: search
	 * searches for a value with a matching key
	 * @param key an object of type <K>
	 * @return if the key matches one of a value in the table, returns that object of type <V>, else returns null
	 */
	@Override
	public V search(K key) {
		HNode<K, V> found = privateSearch(key);
		if (found != null)
			return found.getValue();
		else
			return null;
	}

	/**
	 * Name: privateSearch
	 * searches for a HNode with a matching key
	 * @param key an object of type <K>
	 * @return if the key matches one of a value in the table, returns the HNode that stores that value, else returns null
	 */
	public HNode<K, V> privateSearch(K key) {
		int index = hash((int) key);
		boolean found = false;
		boolean stop = false;
		HNode<K, V> temp = nodes[index];
		if (temp != null) {
			if (temp.getKey().equals(key))
				found = true;
			else {
				while (!found && !stop) {
					if (temp.getKey().equals(key))
						found = true;
					else if (temp.getNext() == null)
						stop = true;
					else
						temp = temp.getNext();
				}
			}
		}
		if (found)
			return temp;
		else
			return null;
	}

	/**
	 * Name: delete
	 * deletes a Node from the if the key matches
	 * @param key an object of type <K>
	 * @return true if the object was successfully removed, false otherwise
	 */
	@Override
	public boolean delete(K key) {
		HNode<K, V> nodeToDelete = privateSearch(key);
		if (nodeToDelete != null) {
			HNode<K, V> prev = nodeToDelete.getPrev();
			HNode<K, V> next = nodeToDelete.getNext();
			if (prev == null) {
				int index = hash((int) key);
				if (next != null) {
					next.setPrev(null);
				}
				nodes[index] = next;
			} else {
				if (next == null)
					prev.setNext(null);
				else {
					prev.setNext(next);
					next.setPrev(prev);
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Name: hash
	 * hashes any positive integer value to an integer between 0 and ARRAY_SIZE, inclusive
	 * @param k the int to be hashed
	 * @return an int between 0 and ARRAY_SIZE, inclusive
	 */
	private int hash(int k) {
		int index = (int) Math.floor(ARRAY_SIZE * ((k * ARBITRARY_NUMBER) % 1));
		return index;
	}

	/**
	 * Name: isEmpty
	 * @return true if there are no values stored in the table, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		boolean result = true;
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] != null)
				result = false;
		}
		return result;
	}
}