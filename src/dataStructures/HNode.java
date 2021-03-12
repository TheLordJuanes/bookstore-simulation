/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package dataStructures;

public class HNode<K, V> {

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

	public HNode(K key, V value) {
		this.value = value;
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public HNode<K, V> getNext() {
		return next;
	}

	public void setNext(HNode<K, V> next) {
		this.next = next;
	}

	public HNode<K, V> getPrev() {
		return prev;
	}

	public void setPrev(HNode<K, V> prev) {
		this.prev = prev;
	}
}