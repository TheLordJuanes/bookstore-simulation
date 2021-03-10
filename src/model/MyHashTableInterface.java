package model;

public interface MyHashTableInterface<K extends Number,V> {
	public void insert(K key, V value);
	public HNode<K,V> search(K key); //Discutir
	public void delete(K key);
}
