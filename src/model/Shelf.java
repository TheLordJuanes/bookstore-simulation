/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package model;

public class Shelf {

	// -----------------------------------------------------------------
	// Attributes
    // -----------------------------------------------------------------

	private String identifier;
	private int bookNum;

	// -----------------------------------------------------------------
	// Methods
    // -----------------------------------------------------------------

	/**
	 * Name: Shelf
	 * Constructor method of a shelf.
	 * @param identifier - shelf's identifier - identifier = String, identifier != null, identifier != ""
	 * @param bookNum - number of book in a shelf - bookNum = int, bookNum != null, bookNum != 0
	*/
	public Shelf(String identifier, int bookNum) {
		this.identifier = identifier;
		this.bookNum = bookNum;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
}