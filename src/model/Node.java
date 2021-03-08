package model;

public class Node<T> {

	private Node<T> nextNode;
	private Node<T> prevNode;
	private T t;

	public Node(T t) {
		this.t = t;
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
		return t;
	}

	public void setValue(T t) {
		this.t = t;
	}
}