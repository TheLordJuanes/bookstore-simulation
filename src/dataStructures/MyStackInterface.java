/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package dataStructures;

import exceptions.MyStackException;

public interface MyStackInterface<T> {

    public T pop() throws MyStackException;
    // Pre: none.
    // Post: If stack is not empty, the item on the top is removed from the stack. Throws StackException if the stack is empty.

    public void push(T value);
    // Pre: item is the new item to be added.
    // Post: If insertion is successful, item is on the top of the stack. Throws StackException if the insertion is not successful.

    public T peek() throws MyStackException;
    // Pre: none.
    // Post: If stack is not empty, the item on the top is returned. The stack is left unchanged. Throws StackException if the stack is empty.

    public boolean isEmpty();
    // Pre: none.
    // Post: Returns true if the stack is empty, otherwise returns false.
}