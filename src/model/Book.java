/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package model;

public class Book {

	// -----------------------------------------------------------------
	// Attributes
    // -----------------------------------------------------------------

	private String isbn;
	private int copies;
	private double price;

	// -----------------------------------------------------------------
	// Methods
    // -----------------------------------------------------------------

	/**
	 * Name: Book
	 * Constructor method of a book.
	 * @param isbn - book ISBN - isbn = String, isbn != null, isbn != ""
	 * @param copies - book copies - copies = int, copies != null
	 * @param price - book price - price = double, price != null
	*/
	public Book(String isbn, int copies, double price) {
		this.isbn = isbn;
		this.copies = copies;
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}