/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package dataStructures;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import exceptions.MyQueueException;
import model.Client;

class MyQueueTest {

	private MyQueue<Client> queue;

	public void setup1() {
		queue = new MyQueue<Client>();
	}

	public void setup2() {
		queue = new MyQueue<Client>();
		Client client = new Client("111", 3);
		queue.enqueue(client);
	}

	public void setup3() {
		queue = new MyQueue<Client>();
		Client client1 = new Client("111", 3);
		queue.enqueue(client1);
		Client client2 = new Client("333", 4);
		queue.enqueue(client2);
	}

	public void setup4() {
		queue = new MyQueue<Client>();
		Client client1 = new Client("111", 3);
		queue.enqueue(client1);
		Client client2 = new Client("333", 4);
		queue.enqueue(client2);
		Client client3 = new Client("555", 5);
		queue.enqueue(client3);
	}

	@Test
	public void testEnqueue() {
		try {
			setup1();
			assertTrue(queue.isEmpty());
			assertNull(queue.getBack());
			Client client1 = new Client("111", 3);
			queue.enqueue(client1);
			assertFalse(queue.isEmpty());
			assertEquals(1, queue.getLength());
			assertEquals("111", queue.getFront().getId());
			assertEquals("111", queue.getBack().getValue().getId());
			setup2();
			assertFalse(queue.isEmpty());
			assertEquals("111", queue.getFront().getId());
			assertEquals(1, queue.getLength());
			Client client2 = new Client("333", 4);
			queue.enqueue(client2);
			assertFalse(queue.isEmpty());
			assertEquals(2, queue.getLength());
			assertEquals("111", queue.getFront().getId());
			assertEquals("333", queue.getBack().getValue().getId());
		} catch (MyQueueException mqe) {
			fail("MyQueueException not expected");
		}
	}

	@Test
	public void testDequeue() {
		try {
			setup1();
			queue.dequeue();
			fail("MyQueueException expected");
		} catch (MyQueueException mse) {
			assertEquals("There is nothing in the queue", mse.getMessage());
			assertTrue(queue.isEmpty());
		}
		try {
			setup2();
			assertFalse(queue.isEmpty());
			assertEquals(1, queue.getLength());
			assertEquals("111", queue.getFront().getId());
			assertEquals("111", queue.getBack().getValue().getId());
			Client c = queue.dequeue();
			assertNotNull(c);
			assertEquals(0, queue.getLength());
			assertNull(queue.getBack());
			assertTrue(queue.isEmpty());
		} catch (MyQueueException mse) {
			fail("MyQueueException not expected");
		}
		try {
			setup3();
			assertFalse(queue.isEmpty());
			assertEquals(2, queue.getLength());
			assertEquals("111", queue.getFront().getId());
			assertEquals("333", queue.getBack().getValue().getId());
			Client c = queue.dequeue();
			assertNotNull(c);
			assertEquals("111", c.getId());
			assertFalse(queue.isEmpty());
			assertEquals(1, queue.getLength());
			assertEquals("333", queue.getFront().getId());
			assertEquals("333", queue.getBack().getValue().getId());
		} catch (MyQueueException mse) {
			fail("MyQueueException not expected");
		}
		try {
			setup4();
			assertFalse(queue.isEmpty());
			assertEquals(3, queue.getLength());
			assertEquals("111", queue.getFront().getId());
			assertEquals("555", queue.getBack().getValue().getId());
			Client c = queue.dequeue();
			assertNotNull(c);
			assertEquals("111", c.getId());
			assertFalse(queue.isEmpty());
			assertEquals(2, queue.getLength());
			assertEquals("333", queue.getFront().getId());
			assertEquals("555", queue.getBack().getValue().getId());
			Client cl = queue.dequeue();
			assertNotNull(cl);
			assertEquals("333", cl.getId());
			assertFalse(queue.isEmpty());
			assertEquals(1, queue.getLength());
			assertEquals("555", queue.getFront().getId());
			assertEquals("555", queue.getBack().getValue().getId());
		} catch (MyQueueException mse) {
			fail("MyQueueException not expected");
		}
	}

	@Test
	public void testGetFront() {
		try {
			setup1();
			queue.getFront();
			fail("MyQueueException expected");
		} catch (MyQueueException mse) {
			assertEquals("There is nothing in the queue", mse.getMessage());
			assertTrue(queue.isEmpty());
		}
		try {
			setup2();
			assertFalse(queue.isEmpty());
			assertEquals(1, queue.getLength());
			Client c = queue.getFront();
			assertNotNull(c);
			assertEquals(1, queue.getLength());
			assertFalse(queue.isEmpty());
		} catch (MyQueueException mse) {
			fail("MyQueueException not expected");
		}
		try {
			setup3();
			assertFalse(queue.isEmpty());
			assertEquals(2, queue.getLength());
			Client c = queue.getFront();
			assertNotNull(c);
			assertEquals("111", c.getId());
			assertFalse(queue.isEmpty());
			assertEquals(2, queue.getLength());
		} catch (MyQueueException mse) {
			fail("MyQueueException not expected");
		}
	}

	@Test
	public void testIsEmpty() {
		setup1();
		assertTrue(queue.isEmpty());
		assertEquals(0, queue.getLength());
		setup2();
		assertFalse(queue.isEmpty());
		assertEquals(1, queue.getLength());
	}
}