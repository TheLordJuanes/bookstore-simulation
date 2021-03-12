/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package dataStructures;

public class Node<T> {

	// -----------------------------------------------------------------
	// Attributes
    // -----------------------------------------------------------------

	private T value;

	// -----------------------------------------------------------------
	// Relations
    // -----------------------------------------------------------------

	private Node<T> nextNode;
	private Node<T> prevNode;

	// -----------------------------------------------------------------
	// Methods
    // -----------------------------------------------------------------

	/**
	 * Name: Node
	 * Constructor method of a node.
	 * @param value - node's value - value = T, value != null
	*/
	public Node(T value) {
		this.value = value;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	public Node<T> getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(Node<T> prevNode) {
		this.prevNode = prevNode;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}