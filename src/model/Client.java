/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package model;

import java.util.ArrayList;
import dataStructures.MyStack;
import exceptions.MyStackException;

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

	public void setBag(MyStack<Book> bag) {
		this.bag = bag;
	}

	private double calculateTotal() throws CloneNotSupportedException, MyStackException {
		double result = 0;
		MyStack<Book> tempBag = bag.cloneThis();
		while (tempBag.getLength() > 0)
			result += tempBag.pop().getPrice();
		return result;
	}

	@Override
	public String toString() {
		String message;
		try {
			message = id + " " + calculateTotal() + "\n" + bag.toString() + "\n";
		} catch (CloneNotSupportedException e) {
			message = e.getMessage();
		} catch (MyStackException e) {
			message = e.getMessage();
		}
		return message;
	}
}