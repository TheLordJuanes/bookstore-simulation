/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package dataStructures;

import exceptions.MyStackException;

public class MyStack<T> implements MyStackInterface<T>, Cloneable {

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

    @SuppressWarnings("unchecked")
    @Override
    public String toString() {
        String info = "";
        MyStack<T> copy;
        try {
            copy = (MyStack<T>) this.clone();
            for (int i = length; i > 0; i--)
                info += copy.pop() + " ";
        } catch (CloneNotSupportedException cnse) {
            cnse.printStackTrace();
        } catch (MyStackException mse) {
            mse.printStackTrace();
        }
        return info;
    }

    @Override
    public T pop() throws MyStackException {
        if (isEmpty())
            throw new MyStackException("The stack is empty.");
        else if (length == 1) {
            T result = top.getValue();
            top = null;
            length--;
            return result;
        } else {
            Node<T> temp = top.getPrevNode();
            Node<T> nodeDeleted = top;
            temp.setNextNode(null);
            top = temp;
            length--;
            return nodeDeleted.getValue();
        }
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
    public T peek() throws MyStackException {
        if (isEmpty())
            throw new MyStackException("The stack is empty.");
        else
            return top.getValue();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @SuppressWarnings("unchecked")
    public MyStack<T> cloneThis() throws CloneNotSupportedException {
        return (MyStack<T>) this.clone();
    }
}