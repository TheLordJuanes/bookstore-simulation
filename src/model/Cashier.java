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

    public Cashier() {
        bag = new MyStack<Book>();
    }

    public boolean isFree() {
        return currentClient == null;
    }

    public Client sayByeToClient() {
        Client tempClient = currentClient;
        tempClient.setBag(bag);
        currentClient = null;
        bag = new MyStack<Book>();
        return tempClient;
    }

    public MyStack<Book> getBag() {
        return bag;
    }

    public void registerBook() throws MyStackException {
        if (!currentClient.getBasket().isEmpty()) {
            Book book = currentClient.getBasket().pop();
            bag.push(book);
        }
    }

    public void setCurrentClient(Client currentClient) {
        this.currentClient = currentClient;
    }

    public Client getCurrentClient() {
        return currentClient;
    }
}