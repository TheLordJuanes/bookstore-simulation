/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package dataStructures;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import exceptions.MyStackException;
import model.Book;

class MyStackTest {

	private MyStack<Book> stack;

	public void setup1() {
		stack = new MyStack<Book>();
	}

	public void setup2() {
		stack = new MyStack<Book>();
		Book book = new Book(333, 2, 20000, "A");
		stack.push(book);
	}

	public void setup3() {
		stack = new MyStack<Book>();
		Book book1 = new Book(333, 2, 20000, "A");
		stack.push(book1);
		Book book2 = new Book(111, 6, 30000, "A");
		stack.push(book2);
	}

	@Test
	public void testPush() {
		try {
			setup1();
			assertTrue(stack.isEmpty());
			Book book1 = new Book(333, 2, 20000, "A");
			stack.push(book1);
			assertFalse(stack.isEmpty());
			assertEquals(1, stack.getLength());
			assertEquals(333, stack.peek().getIsbn());
			setup2();
			assertFalse(stack.isEmpty());
			assertEquals(333, stack.peek().getIsbn());
			Book book2 = new Book(111, 6, 30000, "A");
			stack.push(book2);
			assertEquals(2, stack.getLength());
			assertEquals(111, stack.peek().getIsbn());
		} catch (MyStackException mse) {
			fail("MyStackException not expected");
		}
	}

	@Test
	public void testPop() {
		try {
			setup1();
			stack.pop();
			fail("MyStackException expected");
		} catch (MyStackException mse) {
			assertEquals("The stack is empty.", mse.getMessage());
			assertTrue(stack.isEmpty());
		}
		try {
			setup2();
			assertFalse(stack.isEmpty());
			assertEquals(1, stack.getLength());
			assertEquals(333, stack.peek().getIsbn());
			Book b = stack.pop();
			assertNotNull(b);
			assertEquals(0, stack.getLength());
			assertTrue(stack.isEmpty());
		} catch (MyStackException mse) {
			fail("MyStackException not expected");
		}
		try {
			setup3();
			assertFalse(stack.isEmpty());
			assertEquals(2, stack.getLength());
			assertEquals(111, stack.peek().getIsbn());
			Book b = stack.pop();
			assertNotNull(b);
			assertEquals(111, b.getIsbn());
			assertFalse(stack.isEmpty());
			assertEquals(1, stack.getLength());
			assertEquals(333, stack.peek().getIsbn());
		} catch (MyStackException mse) {
			fail("MyStackException not expected");
		}
	}

	@Test
	public void testPeek() {
		try {
			setup1();
			stack.peek();
			fail("MyStackException expected");
		} catch (MyStackException mse) {
			assertEquals("The stack is empty.", mse.getMessage());
			assertTrue(stack.isEmpty());
		}
		try {
			setup2();
			assertFalse(stack.isEmpty());
			assertEquals(1, stack.getLength());
			Book b = stack.peek();
			assertNotNull(b);
			assertEquals(1, stack.getLength());
			assertFalse(stack.isEmpty());
		} catch (MyStackException mse) {
			fail("MyStackException not expected");
		}
		try {
			setup3();
			assertFalse(stack.isEmpty());
			assertEquals(2, stack.getLength());
			Book b = stack.peek();
			assertNotNull(b);
			assertEquals(111, b.getIsbn());
			assertFalse(stack.isEmpty());
			assertEquals(2, stack.getLength());
		} catch (MyStackException mse) {
			fail("MyStackException not expected");
		}
	}

	@Test
	public void testIsEmpty() {
		setup1();
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.getLength());
		setup2();
		assertFalse(stack.isEmpty());
		assertEquals(1, stack.getLength());
	}

	@Test
	public void testToString() {
		setup3();
		assertEquals("111 333 ", stack.toString(), "The client information isn't the same one.");
	}

	@Test
	public void testCloneThis() {
		try {
			setup2();
			MyStack<Book> clone = stack.cloneThis();
			assertEquals(stack.getLength(), clone.getLength());
			assertEquals(stack.peek(), clone.peek());
		} catch (CloneNotSupportedException cnse) {
			fail("CloneNotSupportedException not expected");
		} catch (MyStackException mse) {
			fail("MyStackException not expected");
		}
	}

	@Test
	public void testGetLength() {
		setup1();
		assertEquals(0, stack.getLength());
		setup2();
		assertEquals(1, stack.getLength());
		setup3();
		assertEquals(2, stack.getLength());
	}
}