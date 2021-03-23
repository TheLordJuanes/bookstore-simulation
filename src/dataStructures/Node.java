/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 23th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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

	/**
	 * Name:getNextNode
	 * gets the next node 
	 * @return nextNode
	 */
	public Node<T> getNextNode() {
		return nextNode;
	}

	/**
	 * Name: setNextNode
	 * sets the next node
	 * @param nextNode a Node<T>
	 */
	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	/**
	 * Name: getPrevNode
	 * gets the previous node
	 * @return prevNode
	 */
	public Node<T> getPrevNode() {
		return prevNode;
	}

	/**
	 * Name: setPrevNode
	 * sets the previous node
	 * @param prevNode a Node<T>
	 */
	public void setPrevNode(Node<T> prevNode) {
		this.prevNode = prevNode;
	}

	/**
	 * Name: getValue
	 * gets the value
	 * @return value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Name: setValue
	 * sets the value
	 * @param value an object of type <T>
	 */
	public void setValue(T value) {
		this.value = value;
	}
}