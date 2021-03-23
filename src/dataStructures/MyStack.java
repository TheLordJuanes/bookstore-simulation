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

    /**
     * Name:getLength
     * gets the length 
     * @return length
     */
    public int getLength() {
        return length;
    }

    @SuppressWarnings("unchecked")
    /**
     * Name: toString
     * @return a String containing the elements in the stack, separated by spaces, from top to bottom
     */
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
    /**
     * Name: pop
     * gets and removes the element at the top of the stack
     * @throws MyStackException if the stack is empty
     * @return the element at the top
     */
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
    /**
     * Name: push
     * adds an element to the stack, as the top
     * @param value object of type <T>
     */
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
    /**
     * Name: peek
     * gets the element at the top of the stack
     * @throws MyStackException if the stack is empty
     * @return the element at the top
     */
    public T peek() throws MyStackException {
        if (isEmpty())
            throw new MyStackException("The stack is empty.");
        else
            return top.getValue();
    }

    @Override
    /**
     * Name: isEmpty
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return length == 0;
    }

    @SuppressWarnings("unchecked")
    /**
     * Name: Clone
     * @return a copy of this object
     * @throws CloneNotSupportedException to indicate that the clone method in class Object has been called to clone an object, but thatthe object's class does not implement the Cloneableinterface
     */
    public MyStack<T> cloneThis() throws CloneNotSupportedException {
        return (MyStack<T>) this.clone();
    }
}