/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package dataStructures;

import exceptions.MyQueueException;

public interface MyQueueInterface<T> {

	/**
     * Name: enqueue
     * adds a new element to the queue
     * @param value the element to be stored
     */
	public void enqueue(T value);
   
	/**
     * Name: isEmpty
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Name: getFront
     * gets the front
     * @throws MyQueueException if the queue is empty
     * @return front
     */
    public T getFront() throws MyQueueException;
    
    /**
     * Name: dequeue
     * retrieves the front and removes it from the queue
     * @throws MyQueueException if the queue is empty
     * @return front
     */
    public T dequeue() throws MyQueueException;
}