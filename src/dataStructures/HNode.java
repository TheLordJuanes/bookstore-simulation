/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package dataStructures;

public class HNode<K extends Number, V> {

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private V value;
	private K key;

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	private HNode<K, V> next;
	private HNode<K, V> prev;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/**
	 * Name: HNode
	 * Constructor method of HNode
	 * @param key an object from a class that extends Number
	 * @param value an object from the class to be considered value
	 */
	public HNode(K key, V value) {
		this.value = value;
		this.key = key;
	}

	/**
	 * Name: getValue
	 * gets the value
	 * @return value
	 */
	public V getValue() {
		return value;
	}

	/**
	 * Name: setValue
	 * sets the value
	 * @param value an object of type <V>
	 */
	public void setValue(V value) {
		this.value = value;
	}

	/**
	 * Name: getKey
	 * gets the key
	 * @return key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * Name: getNext
	 * gets the HNode that is next to the current HNode
	 * @return next
	 */
	public HNode<K, V> getNext() {
		return next;
	}

	/**
	 * Name: setNext
	 * sets the HNode that is next to the current HNode
	 * @param next Hnode
	 */
	public void setNext(HNode<K, V> next) {
		this.next = next;
	}

	/**
	 * Name: getPrev
	 * gets the HNode that is previous to the current HNode
	 * @return prev
	 */
	public HNode<K, V> getPrev() {
		return prev;
	}

	/**
	 * Name: setPrev
	 * sets the HNode that is previous to the current HNode
	 * @param prev Hnode
	 */
	public void setPrev(HNode<K, V> prev) {
		this.prev = prev;
	}
}