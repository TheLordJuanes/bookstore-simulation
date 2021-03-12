package model;

public class Shelf<K extends Number,V> extends MyHashTable<K,V>{
	
	private final String identifier;
	private int bookNum; //Al fin vamos a contabilizar la cantidad de libros que hay?

	
	public Shelf(String identifier, int bookNum) {
		super();
		this.identifier = identifier;
		this.bookNum = bookNum;
	}
	
	//discutir
	public Shelf(String identifier) {
		super();
		this.identifier = identifier;
	}
	
	public String getIdentifier() {
		return identifier;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
}
