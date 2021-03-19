package dataStructures;

import model.Book;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MyHashTableTest {

	private MyHashTable<Integer, Book> tableTest;

	public void setup1() {
		tableTest = new MyHashTable<>();
	}

	public void setup2() {
		setup1();
		int isbn = 1;
		int copies = 3;
		double price = 20000;
		String shelf = "A";
		Book testBook1 = new Book(isbn, copies, price, shelf);
		tableTest.insert(isbn, testBook1);
	}

	@Test
	public void testIsEmpty() {
		setup1();
		assertTrue(tableTest.isEmpty());
		setup2();
		assertFalse(tableTest.isEmpty());
	}

	@Test
	public void testInsert() {
		setup1();
		assertTrue(tableTest.isEmpty());
		int isbn = 441;
		int copies = 3;
		double price = 20000;
		String shelf = "A";
		Book testBook1 = new Book(isbn, copies, price, shelf);

		tableTest.insert(isbn, testBook1);

		Book foundBook = tableTest.search(isbn);
		assertEquals(foundBook, testBook1);
		assertEquals(isbn, foundBook.getIsbn());
		assertEquals(copies, foundBook.getCopies());
		assertEquals(price, foundBook.getPrice());
		assertEquals(shelf, foundBook.getShelf());
		assertNull(tableTest.privateSearch(isbn).getPrev());
		assertNull(tableTest.privateSearch(isbn).getNext());
		int isbn2 = 229;
		int copies2 = 5;
		double price2 = 30000;
		String shelf2 = "A";
		Book testBook2 = new Book(isbn2, copies2, price2, shelf2);

		tableTest.insert(isbn2, testBook2);
		Book foundBook2 = tableTest.search(isbn2);
		assertEquals(testBook2, foundBook2);
		assertEquals(isbn2, foundBook2.getIsbn());
		assertEquals(copies2, foundBook2.getCopies());
		assertEquals(price2, foundBook2.getPrice());
		assertEquals(shelf2, foundBook2.getShelf());
		assertNull(tableTest.privateSearch(isbn).getPrev());
		assertEquals(foundBook2, tableTest.privateSearch(isbn).getNext().getValue());
		assertNull(tableTest.privateSearch(isbn2).getNext());
		assertEquals(foundBook, tableTest.privateSearch(isbn2).getPrev().getValue());
	}

	@Test
	public void testSearch() {

	}

	@Test
	public void testDelete() {

	}

}