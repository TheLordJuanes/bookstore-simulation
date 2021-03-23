/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package model;

import dataStructures.MyStack;
import exceptions.MyStackException;

public class Cashier {

    // -----------------------------------------------------------------
    // Relations
    // -----------------------------------------------------------------

    private Client currentClient;
    private MyStack<Book> bag;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Name: Cashier
     * Constructor method of a cashier 
     */
    public Cashier() {
        bag = new MyStack<Book>();
    }
    
    /**
     * Name: isFree
     * @return true if the cashier has no current client
     */
    public boolean isFree() {
        return currentClient == null;
    }

    /**
     * Name: sayByeToClient
     * gives the bag to the client and empties own bag and current client
     * @return a Client with a filled bag
     */
    public Client sayByeToClient() {
        Client tempClient = currentClient;
        tempClient.setBag(bag);
        currentClient = null;
        bag = new MyStack<Book>();
        return tempClient;
    }

    /**
     * Name: getBag
     * gets the bag
     * @return bag
     */
    public MyStack<Book> getBag() {
        return bag;
    }

    /**
     * Name: registerBook
     * registers a book from the client's basket and puts it in the bag
     * @throws MyStackException if the basket is empty
     */
    public void registerBook() throws MyStackException {
        if (!currentClient.getBasket().isEmpty()) {
            Book book = currentClient.getBasket().pop();
            bag.push(book);
        }
    }

    /**
     * Name: setCurrentClient
     * sets the currentClient
     * @param currentClient a Client
     */
    public void setCurrentClient(Client currentClient) {
        this.currentClient = currentClient;
    }

    /**
     * Name: getCurrentClient
     * @return currentClient
     */
    public Client getCurrentClient() {
        return currentClient;
    }
}