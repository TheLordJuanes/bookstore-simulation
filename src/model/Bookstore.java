/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package model;

import java.util.ArrayList;

public class Bookstore {

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	private ArrayList<Shelf<Integer, Double>> shelves;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/**
	 * Name: Bookstore
	 * Constructor method of a bookstore.
	*/
	public Bookstore() {
		shelves = new ArrayList<>();
		shelves.add(null);
	}

	public void addBook(String bIsbn, String numberOfCopies, char bookShelf, double bookPrice) {

	}

	public void orderClientsBooks() {
	}

	public Book searchBook() {
		return null;
	}

	public void orderClientsByTime() {
	}

	public void simulatePayment() {
	}

	public double calculatePayment() {
		return 0;
	}

	public String[] resultsReport() {
		return null;
	}
}