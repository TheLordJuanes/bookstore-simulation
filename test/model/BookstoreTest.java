/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 23th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import exceptions.MyQueueException;
import exceptions.MyStackException;

public class BookstoreTest {

    private Bookstore bs;

    public void setup1() {
        bs = new Bookstore();
        bs.addCashiers(3);
        bs.createShelves(3);
        bs.addBook(971, 6, "A", 70000);
        bs.addBook(612, 2, "A", 80000);
        bs.addBook(465, 6, "A", 60000);
        bs.addBook(331, 3, "A", 17000);
        bs.addBook(112, 6, "B", 22000);
        bs.addBook(441, 3, "B", 30000);
        bs.addBook(229, 6, "B", 28000);
        bs.addBook(281, 2, "B", 38000);
        bs.addBook(333, 6, "B", 43000);
        bs.addBook(767, 2, "C", 40000);
        bs.addBook(287, 6, "C", 65000);
        bs.addClient("1627");
        bs.addClient("3456");
        bs.addClient("3219");
        bs.addClient("3311");
        bs.addClient("2100");
        bs.addBookToClient("1627", 287);
        bs.addBookToClient("1627", 612);
        bs.addBookToClient("3456", 612);
        bs.addBookToClient("3456", 333);
        bs.addBookToClient("3456", 287);
        bs.addBookToClient("3456", 465);
        bs.addBookToClient("3219", 287);
        bs.addBookToClient("3311", 767);
        bs.addBookToClient("3311", 287);
        bs.addBookToClient("3311", 229);
        bs.addBookToClient("3311", 971);
        bs.addBookToClient("2100", 331);
    }

    // new
    public void setup2() {
        bs = new Bookstore();
    }

    // 3 cashiers, 3 shelves
    public void setup3() {
        bs = new Bookstore();
        bs.addCashiers(3);
        bs.createShelves(3);
    }

    // one client
    public void setup4() {
        bs = new Bookstore();
        bs.addClient("1111");
    }

    // 3 cashiers, 3 shelves, one book, one client
    public void setup5() {
        setup3();
        int isbn = 441;
        int copies = 3;
        double price = 20000;
        String shelf = "A";
        bs.addClient("1111");
        bs.addBook(isbn, copies, shelf, price);
    }

    @Test
    public void testGiveResult() {
        setup1();
        try {
            String result = bs.giveResult('B');
            BufferedReader br = new BufferedReader(new FileReader("resources/output1.txt"));
            String[] parts = result.split("\n");
            for (int i = 0; i < parts.length; i++) {
                String expected = br.readLine();
                String actual = parts[i];
                assertEquals(expected, actual);
            }
            br.close();
        } catch (MyQueueException e) {
            fail("MyQueueException not expected");
        } catch (MyStackException e) {
            fail("MyStackException not expected");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddClient() {
        setup2();
        assertEquals(0, bs.getClients().size());
        assertEquals(false, bs.addClient("1111"));
        assertEquals(1, bs.getClients().size());
        setup4();
        assertEquals(1, bs.getClients().size());
        assertEquals(true, bs.addClient("1111"));
        assertEquals(1, bs.getClients().size());
        assertEquals(false, bs.addClient("2222"));
        assertEquals(2, bs.getClients().size());
    }

    @Test
    public void testAddBook() {
        setup3();
        assertTrue(bs.areShelvesEmpty());
        int isbn = 441;
        int copies = 3;
        double price = 20000;
        String shelf = "A";

        bs.addBook(isbn, copies, shelf, price);

        Book foundBook = bs.searchBook(isbn);
        assertEquals(isbn, foundBook.getIsbn());
        assertEquals(copies, foundBook.getCopies());
        assertEquals(price, foundBook.getPrice());
        assertEquals(shelf, foundBook.getShelf());
        assertFalse(bs.areShelvesEmpty());
    }

    @Test
    public void testAddBookToClient() {
        setup5();
        bs.addBookToClient("1111", 441);
        ArrayList<Client> clients = bs.getClients();
        assertEquals("1111", clients.get(0).getId());
        assertEquals(1, clients.get(0).getTime());
        ArrayList<Integer> isbns = new ArrayList<Integer>();
        isbns.add(441);
        assertEquals(isbns, clients.get(0).getISBNList());
        assertTrue(clients.get(0).getBasket().isEmpty());
        assertTrue(clients.get(0).getBag().isEmpty());
    }

    @Test
    public void testAddCashiers() {
        setup2();
        assertTrue(bs.getNumberOfCashiers() == 0);
        bs.addCashiers(3);
        assertTrue(bs.getNumberOfCashiers() == 3);
    }

    @Test
    public void testCreateShelves() {
        setup2();
        assertTrue(bs.getNumberOfShelves() == 0);
        bs.createShelves(3);
        assertTrue(bs.getNumberOfShelves() == 3);
    }
}