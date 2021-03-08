package model;

public class Book {

	private String isbn;
	private int copies;
	private double price;

	/**
	 *
	 * @param isbn
	 * @param copies
	 * @param price
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