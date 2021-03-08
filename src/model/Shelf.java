package model;

public class Shelf {

	private String identifier;
	private int bookNum;

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