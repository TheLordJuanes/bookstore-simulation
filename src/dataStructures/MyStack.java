/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package dataStructures;

public class MyStack<T> implements MyStackInterface<T> {

    // -----------------------------------------------------------------
	// Attributes
    // -----------------------------------------------------------------

    private int length;

    // -----------------------------------------------------------------
	// Relations
    // -----------------------------------------------------------------

    private Node<T> top;

    // -----------------------------------------------------------------
	// Methods
    // -----------------------------------------------------------------

    /**
	 * Name: MyStack
	 * Constructor method of a stack.
	*/
    public MyStack() {
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Node<T> getTop() {
        return top;
    }

    public void setTop(Node<T> top) {
        this.top = top;
    }

    @Override
    public T pop() {
        Node<T> temp = top.getPrevNode();
        Node<T> nodeDeleted = top;
        temp.setNextNode(null);
        top = temp;
        length--;
        return nodeDeleted.getValue();
    }

    @Override
    public void push(T value) {
        Node<T> newNode = new Node<T>(value);
        if (!isEmpty()) {
            top.setNextNode(newNode);
            newNode.setPrevNode(top);
        }
        top = newNode;
        length++;
    }

    @Override
    public T peek() {
        return top.getValue();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }
}