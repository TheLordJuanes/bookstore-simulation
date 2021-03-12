package model;
import dataStructures.MyHashTable;

public class Shelf<K extends Number,V> extends MyHashTable<K,V>{
	
	private final String identifier;
	
	public Shelf(String identifier) {
		super();
		this.identifier = identifier;
	}
	
	public String getIdentifier() {
		return identifier;
	}

}
