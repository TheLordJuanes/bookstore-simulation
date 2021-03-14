/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package dataStructures;

public class MyHashTable<K extends Number, V> implements MyHashTableInterface<K, V> {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	public static final int ARRAY_SIZE = 16;
	public static final double ARBITRARY_NUMBER = (Math.sqrt(5) - 1.0) / 2.0;

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	private final String identifier;

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	//private ArrayList<HNode<K, V>> nodes;
	private HNode<K,V>[] nodes;

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
	public MyHashTable(String identifier) {
		nodes = (HNode<K, V>[]) new HNode[ARRAY_SIZE];
		this.identifier = identifier;
		// nodes=(HNode<K,V>[]) new Object[ARRAY_SIZE]; //To discuss
		/**
		 * nodes = new ArrayList<>(); for (int i = 0; i < ARRAY_SIZE; i++)
		 * nodes.add(null);
		 */
	}

	public String getIdentifier() {
		return identifier;
	}

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
			node.setPrev(node);
		}
	}

	@Override
	public V search(K key) {
		HNode<K, V> found = privateSearch(key);
		if (found != null)
			return found.getValue();
		else
			return null;
	}

	private HNode<K, V> privateSearch(K key) {
		int index = hash((int) key);
		boolean found = true;
		HNode<K, V> temp = nodes[index];
		if (temp != null) {
			while (temp.getKey() != key && found) {
				if (temp.getPrev() != null)
					temp = temp.getNext();
				else
					found = false;
			}
		} else
			found = false;
		if (found)
			return temp;
		else
			return null;
	}

	@Override
	public void delete(K key) {
		HNode<K, V> nodeToDelete = privateSearch(key);
		if (nodeToDelete != null) {
			HNode<K, V> prev = nodeToDelete.getPrev();
			HNode<K, V> next = nodeToDelete.getNext();
			if (prev == null) {
				int index = hash((int) key);
				next.setPrev(null);
				nodes[index] = next;
			} else {
				if (next == null)
					prev.setNext(null);
				else {
					prev.setNext(next);
					next.setPrev(prev);
				}
			}
		}
	}

	public int hash(int k) {
		int index = (int) Math.floor(ARRAY_SIZE * ((k * ARBITRARY_NUMBER) % 1));
		return index;
	}
}