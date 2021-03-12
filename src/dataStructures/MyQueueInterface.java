/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package dataStructures;

import exceptions.MyQueueException;

public interface MyQueueInterface<T> {

    public void enqueue(T value);
    // Pre:item is the new item to be added.
    // Post: If insertion is successful, item is at the end of the queue. Throws QueueException if the item cannot be added to the queue.

    public boolean isEmpty();
    // Pre: none.
    // Post: Returns true if the queue is empty, otherwise returns false.

    public T getFront() throws MyQueueException;
    // Pre: none.
    // Post: If queue is not empty, the item at the front of a queue is returned, and the queue is left unchanged. Throws QueueException if the queue is empty.

    public T dequeue() throws MyQueueException;
    // Pre: none.
    // Post: If queue is not empty, the item at the front of the queue is retrieved and removed from the queue. Throws QueueException if the queue is empty.
}