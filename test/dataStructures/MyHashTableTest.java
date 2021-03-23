/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 23th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package dataStructures;

import model.Book;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MyHashTableTest {

	private MyHashTable<Integer, Book> tableTest;

	// empty
	public void setup1() {
		tableTest = new MyHashTable<>();
	}

	// one book
	public void setup2() {
		setup1();
		int isbn = 441;
		int copies = 3;
		double price = 20000;
		String shelf = "A";
		Book testBook1 = new Book(isbn, copies, price, shelf);
		tableTest.insert(isbn, testBook1);
	}

	// two books, no collision
	public void setup3() {
		setup2();

		int isbn3 = 159;
		int copies3 = 10;
		double price3 = 100000;
		String shelf3 = "A";
		Book testBook3 = new Book(isbn3, copies3, price3, shelf3);
		tableTest.insert(isbn3, testBook3);
	}

	// two books, collision
	public void setup4() {
		setup2();
		int isbn2 = 229;
		int copies2 = 5;
		double price2 = 30000;
		String shelf2 = "A";
		Book testBook2 = new Book(isbn2, copies2, price2, shelf2);

		tableTest.insert(isbn2, testBook2);
	}

	// three books, one collision
	public void setup5() {
		setup3();
		int isbn2 = 229;
		int copies2 = 5;
		double price2 = 30000;
		String shelf2 = "A";
		Book testBook2 = new Book(isbn2, copies2, price2, shelf2);

		tableTest.insert(isbn2, testBook2);
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

		setup2();

		int isbn3 = 159;
		int copies3 = 10;
		double price3 = 100000;
		String shelf3 = "A";
		Book testBook3 = new Book(isbn3, copies3, price3, shelf3);

		tableTest.insert(isbn3, testBook3);

		Book foundBook3 = tableTest.search(isbn3);
		assertEquals(foundBook3, testBook3);
		assertEquals(isbn3, foundBook3.getIsbn());
		assertEquals(copies3, foundBook3.getCopies());
		assertEquals(price3, foundBook3.getPrice());
		assertEquals(shelf3, foundBook3.getShelf());
		assertNull(tableTest.privateSearch(isbn3).getPrev());
		assertNull(tableTest.privateSearch(isbn3).getNext());
		Book foundBook1 = tableTest.search(441);

		assertEquals(441, foundBook1.getIsbn());
		assertEquals(3, foundBook1.getCopies());
		assertEquals(20000, foundBook1.getPrice());
		assertEquals("A", foundBook1.getShelf());
		assertNull(tableTest.privateSearch(441).getPrev());
		assertNull(tableTest.privateSearch(441).getNext());
	}

	@Test
	public void testSearch() {
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
		assertNull(tableTest.privateSearch(isbn).getPrev());
		assertEquals(foundBook2, tableTest.privateSearch(isbn).getNext().getValue());
		assertNull(tableTest.privateSearch(isbn2).getNext());
		assertEquals(foundBook, tableTest.privateSearch(isbn2).getPrev().getValue());

		setup2();

		int isbn3 = 159;
		int copies3 = 10;
		double price3 = 100000;
		String shelf3 = "A";
		Book testBook3 = new Book(isbn3, copies3, price3, shelf3);

		tableTest.insert(isbn3, testBook3);

		Book foundBook3 = tableTest.search(isbn3);
		assertEquals(foundBook3, testBook3);
		assertNull(tableTest.privateSearch(isbn3).getPrev());
		assertNull(tableTest.privateSearch(isbn3).getNext());
		Book foundBook1 = tableTest.search(441);

		assertEquals(441, foundBook1.getIsbn());
		assertEquals(3, foundBook1.getCopies());
		assertEquals(20000, foundBook1.getPrice());
		assertEquals("A", foundBook1.getShelf());
		assertNull(tableTest.privateSearch(441).getPrev());
		assertNull(tableTest.privateSearch(441).getNext());
	}

	@Test
	public void testDelete() {
		setup1();
		assertFalse(tableTest.delete(1));
		assertTrue(tableTest.isEmpty());

		setup2();
		assertFalse(tableTest.isEmpty());
		assertTrue(tableTest.delete(441));
		assertNull(tableTest.search(441));
		assertTrue(tableTest.isEmpty());

		setup3();
		assertTrue(tableTest.delete(441));
		assertNull(tableTest.search(441));
		assertFalse(tableTest.isEmpty());
		setup3();
		assertTrue(tableTest.delete(159));
		assertNull(tableTest.search(159));
		assertFalse(tableTest.isEmpty());

		setup4();// 441 229
		assertTrue(tableTest.delete(441));
		assertNull(tableTest.search(441));
		assertFalse(tableTest.isEmpty());
		assertNull(tableTest.privateSearch(229).getPrev());
		assertNull(tableTest.privateSearch(229).getNext());
		setup4();
		assertTrue(tableTest.delete(229));
		assertNull(tableTest.search(229));
		assertFalse(tableTest.isEmpty());
		assertNull(tableTest.privateSearch(441).getPrev());
		assertNull(tableTest.privateSearch(441).getNext());
	}
}