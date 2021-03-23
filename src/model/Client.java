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

	/**
	 * Name: getId
	 * gets the id
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Name: getTime
	 * gets the time
	 * @return time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Name: setTime
	 * sets the time
	 * @param time an int
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * Name: getBokList
	 * returns a String containing the isbns if the books int the ISBNList, separated by \n
	 * @return a String
	 */
	public String getBookList() {
		String list = "";
		for (int i = 0; i < ISBNList.size(); i++)
			list += ISBNList.get(i) + "\n";
		return list;
	}

	/**
	 * Name: getISBNList
	 * gets the ISBNList
	 * @return ISBNList
	 */
	public ArrayList<Integer> getISBNList() {
		return ISBNList;
	}

	/**
	 * Name: setISBNList
	 * sets the ISBNList
	 * @param iSBNList an ArrayList of Integer
	 */
	public void setISBNList(ArrayList<Integer> iSBNList) {
		ISBNList = iSBNList;
	}

	/**
	 * Name: getBasket
	 * gets the basket
	 * @return basket
	 */
	public MyStack<Book> getBasket() {
		return basket;
	}

	/**
	 * Name: setBasket
	 * sets the basket
	 * @param basket a MyStack of Book
	 */
	public void setBasket(MyStack<Book> basket) {
		this.basket = basket;
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
	 * Name: setBag
	 * sets the bag
	 * @param bag a MyStack of Book
	 */
	public void setBag(MyStack<Book> bag) {
		this.bag = bag;
	}

	/**
	 * Name: calculateTotal
	 * Method used to calculate the total price of the books to buy.
	 * <b>pre: </b> Books' bag of the client already initialized. <br>
	 * <b>post: </b> The total price of the books to buy has been calculated. <br>
	 * @throws CloneNotSupportedException - to indicate that the object's class doesn't implement the Cloneable interface.
	 * @throws MyStackException - when trying to access and/or delete an element in an empty stack.
	 * @return A double representing the total price of the books to buy.
	*/
	private double calculateTotal() throws CloneNotSupportedException, MyStackException {
		double result = 0;
		MyStack<Book> tempBag = bag.cloneThis();
		while (tempBag.getLength() > 0)
			result += tempBag.pop().getPrice();
		return result;
	}

	/** Name: toString
	 * Method rewritten used to print a String that textually represents an object of from Client class with its elements.
	 * @return A String representing information of a client.
  	*/
	@Override
	public String toString() {
		String message;
		try {
			message = id + " " + calculateTotal() + "\n" + bag.toString() + "\n";
		} catch (CloneNotSupportedException cnse) {
			message = cnse.getMessage();
		} catch (MyStackException mse) {
			message = mse.getMessage();
		}
		return message;
	}
}