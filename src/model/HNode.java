package model;

public class HNode<K, V> {
	
	private V value;
	private K key;
	
	private HNode<K,V> next;
	private HNode<K,V> prev;
	
	public HNode(K key, V value) {
		this.value=value;
		this.key=key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}

	public HNode<K, V> getNext() {
		return next;
	}

	public void setNext(HNode<K, V> next) {
		this.next = next;
	}

	public HNode<K, V> getPrev() {
		return prev;
	}

	public void setPrev(HNode<K, V> prev) {
		this.prev = prev;
	}

}
