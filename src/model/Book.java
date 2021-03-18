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
	public Book(int isbn, int copies, double price,String shelf) {
		this.isbn = isbn;
		this.shelf = shelf;
		this.copies = copies;
		this.price = price;
	}

	public void decreaseCopies() {
		copies--;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getShelf() {
		return shelf;
	}

	public void setShelf(String shelf) {
		this.shelf= shelf;
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

	public String toString(){
		return String.valueOf(isbn);
	}
}