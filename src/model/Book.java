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

	private int isbn;
	private String shelf;
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
	public Book(int isbn, int copies, double price, String shelf) {
		this.isbn = isbn;
		this.shelf = shelf;
		this.copies = copies;
		this.price = price;
	}

	/**
	 * Name: Decrease copies
	 * Decreases the attribute copies of the book
	 */
	public void decreaseCopies() {
		copies--;
	}

	/**
	 * Name: getIsbn
	 * Gets the isbn
	 * @return isbn
	 */
	public int getIsbn() {
		return isbn;
	}

	/**
	 * Name: setIsbn
	 * sets the isbn
	 * @param isbn an int
	 */
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	/**
	 * Name:  getShelf
	 * gets the shelf
	 * @return shelf
	 */
	public String getShelf() {
		return shelf;
	}

	/**
	 * Name: setShelf
	 * sets the shelf
	 * @param shelf a String containing the identifier of the shelf
	 */
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	/**
	 * Name: getCopies
	 * gets the number of copies
	 * @return copies
	 */
	public int getCopies() {
		return copies;
	}

	/**
	 * Name: setCopies
	 * sets copies
	 * @param copies an int
	 */
	public void setCopies(int copies) {
		this.copies = copies;
	}

	/**
	 * Name: getPrice
	 * gets the price
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Name: setPrice
	 * sets the price
	 * @param price an int
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Name: toString
	 * returns a string containing the isbn of the book
	 */
	public String toString() {
		return String.valueOf(isbn);
	}
}