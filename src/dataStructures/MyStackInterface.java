/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package dataStructures;

import exceptions.MyStackException;

public interface MyStackInterface<T> {

	/**
     * Name: pop
     * gets and removes the element at the top of the stack
     * @throws MyStackException if the stack is empty
     * @return the element at the top
     */
    public T pop() throws MyStackException;
    
    /**
     * Name: push
     * adds an element to the stack, as the top
     * @param value object of type <T>
     */
    public void push(T value);
   
    /**
     * Name: peek
     * gets the element at the top of the stack
     * @throws MyStackException if the stack is empty
     * @return the element at the top
     */
    public T peek() throws MyStackException;
    
    /**
     * Name: isEmpty
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty();
    
}