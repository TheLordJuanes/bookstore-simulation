/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package dataStructures;

import java.util.ArrayList;
import exceptions.MyQueueException;

public class MyQueue<T> implements MyQueueInterface<T>, Cloneable {

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    private int length;

    // -----------------------------------------------------------------
    // Relations
    // -----------------------------------------------------------------

    private Node<T> front;
    private Node<T> back;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Name: MyQueue
     * Constructor method of a queue.
    */
    public MyQueue() {
        length = 0;
    }

    /**
     * Name: MyQueue
     * Constructor method of a queue.
     * @param list an ArrayList of T, enqueues every element in the queue
     */
    public MyQueue(ArrayList<T> list) {
        length = 0;
        for (int i = 0; i < list.size(); i++)
            this.enqueue(list.get(i));
    }

    /**
     * Name: getLength
     * gets the length
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**
     * Name: setLength
     * sets the length
     * @param length an int
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * setFront
     * sets the front
     * @param front a Node<T>
     */
    public void setFront(Node<T> front) {
        this.front = front;
    }
    /**
     * Name: getBack
     * gets the back
     * @return back
     */
    public Node<T> getBack() {
        return back;
    }

    /**
     * Name: setBack
     * sets the back
     * @param back a Node<T>
     */
    public void setBack(Node<T> back) {
        this.back = back;
    }

    @Override
    /**
     * Name: enqueue
     * adds a new element to the queue
     * @param value the element to be stored
     */
    public void enqueue(T value) {
        Node<T> newNode = new Node<T>(value);
        if (isEmpty()) {
            front = newNode;
            back = newNode;
        } else {
            newNode.setNextNode(back);
            back.setPrevNode(newNode);
            back = newNode;
        }
        length++;
    }

    
    @Override
    /**
     * Name: isEmpty
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    /**
     * Name: getFront
     * gets the front
     * @throws MyQueueException if the queue is empty
     * @return front
     */
    public T getFront() throws MyQueueException {
        if (isEmpty())
            throw new MyQueueException("There is nothing in the queue");
        else
            return front.getValue();
    }

    @Override
    /**
     * Name: dequeue
     * retrieves the front and removes it from the queue
     * @throws MyQueueException if the queue is empty
     * @return front
     */
    public T dequeue() throws MyQueueException {
        if (isEmpty())
            throw new MyQueueException("There is nothing in the queue");
        else {
            T value = front.getValue();
            if (getLength() == 1) {
                front = null;
                back = null;
            } else {
                front.getPrevNode().setNextNode(null);
                front = front.getPrevNode();
            }
            length--;
            return value;
        }
    }
}