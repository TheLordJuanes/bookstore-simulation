/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package model;

import java.util.ArrayList;
import dataStructures.MyStack;

public class Client {

	// -----------------------------------------------------------------
	// Attributes
    // -----------------------------------------------------------------

	private String id;
	private int time;

	// -----------------------------------------------------------------
	// Relations
    // -----------------------------------------------------------------

	private ArrayList<Integer> ISBNList;
	private MyStack<Book> basket;
	private MyStack<Book> bag;

	// -----------------------------------------------------------------
	// Methods
    // -----------------------------------------------------------------

	/**
	 * Name: Client
	 * Constructor method of a client.
	 * @param id - client's ID - id = String, id != null, id != ""
	 * @param time - time taken for a client in sections 2 and 3 - time = int, time != null, time != 0
	*/
	public Client(String id, int time) {
		this.id = id;
		this.time = time;
		ISBNList = new ArrayList<Integer>();
		basket = new MyStack<Book>();
		bag = new MyStack<Book>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getBookList() {
		String list = "";
		for (int i = 0; i < ISBNList.size(); i++)
			list += ISBNList.get(i) + "\n";
		return list;
	}

	public ArrayList<Integer> getISBNList() {
		return ISBNList;
	}

	public void setISBNList(ArrayList<Integer> iSBNList) {
		ISBNList = iSBNList;
	}

	public MyStack<Book> getBasket() {
		return basket;
	}

    public void setBasket(MyStack<Book> basket) {
        this.basket = basket;
    }

    public MyStack<Book> getBag() {
        return bag;
    }

	private double calculateTotal() {
		double result=0;
		return result;
	}

    public void setBag(MyStack<Book> bag) {
        this.bag = bag;
    }

	@Override
	public String toString(){
		String message=id +" " + calculateTotal()+"\n"+
		bag.toString();
		return message;
	}
}