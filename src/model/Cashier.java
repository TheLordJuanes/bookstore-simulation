/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package model;

import dataStructures.MyStack;

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

    public void sayByeToClient() {
        currentClient = null;
        bag = new MyStack<Book>();
    }

    public MyStack<Book> getBag() {
        return bag;
    }

    public void registerBook(Book book) {
        bag.push(book);
    }

    public void setCurrentClient(Client currentClient) {
        this.currentClient = currentClient;
    }
}