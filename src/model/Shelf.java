package model;

public class Shelf<K extends Number,V> extends MyHashTable<K,V>{
	
	private String identifier;
	private int bookNum; //Al fin vamos a contabilizar la cantidad de libros que hay?

	public Shelf(String identifier, int bookNum) {
		super();
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
