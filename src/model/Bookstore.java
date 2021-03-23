/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import dataStructures.MyStack;
import exceptions.MyQueueException;
import exceptions.MyStackException;
import dataStructures.MyQueue;

public class Bookstore {

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	private ArrayList<Shelf<Integer, Book>> shelves;
	private ArrayList<Client> clients;
	private Cashier[] cashiers;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/**
	 * Name: Bookstore
	 * Constructor method of a bookstore.
	*/
	public Bookstore() {
		shelves = new ArrayList<>();
		clients = new ArrayList<>();
		cashiers = new Cashier[0];
	}

	/**
	 * Name: getClients
	 * gets the clients
	 * @return clients
	 */
	public ArrayList<Client> getClients() {
		return clients;
	}

	/**
	 * addCashiers
	 * creates the number of cashiers indicated
	 * @param numberOfCashiers an int
	 */
	public void addCashiers(int numberOfCashiers) {
		cashiers = new Cashier[numberOfCashiers];
		for (int i = 0; i < numberOfCashiers; i++)
			cashiers[i] = new Cashier();
	}

	/**
	 * Name: getNumberOfCashiers
	 * gets the number of cashiers
	 * @return an int
	 */
	public int getNumberOfCashiers() {
		return cashiers.length;
	}

	/**
	 * Name: addBookToClient
	 * if the book exists, it is added to the clients ISBNList
	 * @param id the id of the client
	 * @param isbn the isbn of the book
	 * @return true if added successfully, false otherwise
	 */
	public boolean addBookToClient(String id, int isbn) {
		boolean found = false;
		if (checkBook(isbn)) {
			for (int i = 0; i < clients.size() && !found; i++) {
				if (clients.get(i).getId().equals(id)) {
					clients.get(i).getISBNList().add(isbn);
					found = true;
				}
			}
		}
		return found;
	}

	/**
	 * Name: areShelvesEmpty
	 * @return true if the shelves are empty, false otherwise
	 */
	public boolean areShelvesEmpty() {
		boolean result = true;
		for (int i = 0; i < shelves.size(); i++) {
			if (!shelves.get(i).isEmpty())
				result = false;
		}
		return result;
	}

	/**
	 * Name: addBook if the book does not already exist, it is added to the bookshelf indicated
	 * @param bIsbn the isbn of the book
	 * @param numberOfCopies the number of copies of the book
	 * @param bookShelf the identifier of the shelf
	 * @param bookPrice the price of the book
	 * @return true if the book was not added (already existed), false otherwise
	 */
	public boolean addBook(int bIsbn, int numberOfCopies, String bookShelf, double bookPrice) {
		Book newBook = new Book(bIsbn, numberOfCopies, bookPrice, bookShelf);
		boolean alreadyExist = checkBook(bIsbn);
		boolean found = false;
		for (int i = 0; i < shelves.size() && !found && !alreadyExist; i++) {
			if (shelves.get(i).getIdentifier().equals(bookShelf)) {
				shelves.get(i).insert(bIsbn, newBook);
				found = true;
			}
		}
		return alreadyExist;
	}

	/**
	 * Name: addBook if the book does not already exist, it is added to the bookshelf indicated
	 * @param bIsbn the isbn of the book
	 * @param numberOfCopies the number of copies of the book
	 * @param bookShelfPosition the index of the shelf in shelves
	 * @param bookPrice the price of the book
	 * @return true if the book was not added (already existed), false otherwise
	 */
	public boolean addBook(int bIsbn, int numberOfCopies, int bookShelfPosition, double bookPrice) {
		String bookShelf = shelves.get(bookShelfPosition).getIdentifier();
		Book newBook = new Book(bIsbn, numberOfCopies, bookPrice, bookShelf);
		boolean alreadyExist = checkBook(bIsbn);
		boolean found = false;
		for (int i = 0; i < shelves.size() && !found && !alreadyExist; i++) {
			if (shelves.get(i).getIdentifier().equals(bookShelf)) {
				shelves.get(i).insert(bIsbn, newBook);
				found = true;
			}
		}
		return alreadyExist;
	}

	/**
	 * Name: checkBook
	 * checks if a book already exists
	 * @param isbn of the book to search
	 * @return true if it already existed, false otherwise
	 */
	private boolean checkBook(int isbn) {
		boolean found = false;
		for (int i = 0; i < shelves.size() && !found; i++) {
			if (shelves.get(i).search(isbn) != null)
				found = true;
		}
		return found;
	}

	/**
	 * Name: searchBook
	 * searches for a book in all the shelves
	 * @param isbn of the book to search
	 * @return The book if it exists, null otherwise
	 */
	public Book searchBook(int isbn) {
		boolean found = false;
		Book searchedBook = null;
		for (int i = 0; i < shelves.size() && !found; i++) {
			if (shelves.get(i).search(isbn) != null) {
				searchedBook = shelves.get(i).search(isbn);
				found = true;
			}
		}
		return searchedBook;
	}

	/**
	 * Name: addClient
	 * adds a client
	 * @param id of the client to add
	 * @return false if the client was added, true if it already existed
	 */
	public boolean addClient(String id) {
		boolean exist = false;
		for (int i = 0; i < clients.size() && !exist; i++) {
			if (clients.get(i).getId().equals(id))
				exist = true;
		}
		if (!exist) {
			int time = clients.size() + 1;
			clients.add(new Client(id, time));
		}
		return exist;
	}

	/**
	 * Name: createListBooks
	 * creates a list of Book by searching the books by their isbn
	 * @param isbnList a list of the isbns of the books to be searched
	 * @return an ArrayList of Book
	 */
	private ArrayList<Book> createListBooks(ArrayList<Integer> isbnList) {
		ArrayList<Book> books = new ArrayList<Book>();
		for (int i = 0; i < isbnList.size(); i++) {
			Book found = searchBook(isbnList.get(i));
			if (found != null)
				books.add(found);
		}
		return books;
	}

	/**
	 * Name: orderClientsBooks
	 * orders the client's list of Books by their shelf and their isbn
	 * @param sortingAlgorithm a char representing the sorting algorithm to be used (B, H or M)
	 * @param currentClient the client whose books are to be organized
	 */
	public void orderClientsBooks(char sortingAlgorithm, Client currentClient) {
		ArrayList<Book> result;
		ArrayList<Book> books = createListBooks(currentClient.getISBNList());
		switch (sortingAlgorithm) {
			case 'B':
				result = bubbleSort(books);
				break;
			case 'H':
				result = heapSort(books);
				break;
			default:
				result = mergeSort(books, 0, books.size() - 1);
				break;
		}
		ArrayList<Integer> isbns = booksToISBN(result);
		currentClient.setISBNList(isbns);
	}

	/**
	 * Name: booksToISBN
	 * creates a list of the ISBNs of the books given
	 * @param books a List of Book
	 * @return ArrayList of Integer
	 */
	private ArrayList<Integer> booksToISBN(List<Book> books) {
		ArrayList<Integer> isbns = new ArrayList<>();
		for (int i = 0; i < books.size(); i++)
			isbns.add(books.get(i).getIsbn());
		return isbns;
	}

	/**
	 * Name: mergeSort
	 * sorts the books using mergeSort, method adapted from GeeksForGeeks https://www.geeksforgeeks.org/merge-sort/
	 * @param books the ArrayList of Book to be sorted
	 * @param l an int
	 * @param r an int
	 * @return books, organized
	 */
	private ArrayList<Book> mergeSort(ArrayList<Book> books, int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			mergeSort(books, l, m);
			mergeSort(books, m + 1, r);
			merge(books, l, m, r);
		}
		return books;
	}

	/**
	 * Name: merge
	 * auxiliary method of merge sort // method adapted from GeeksForGeeks https://www.geeksforgeeks.org/merge-sort/
	 * @param arr the ArrayList of Book to be sorted
	 * @param l an int
	 * @param m an int
	 * @param r an int
	 * @return arr, sorted
	 */
	private ArrayList<Book> merge(ArrayList<Book> arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		ArrayList<Book> L = new ArrayList<Book>();
		ArrayList<Book> R = new ArrayList<Book>();
		for (int i = 0; i < n1; ++i)
			L.add(i, arr.get(l + i));
		for (int j = 0; j < n2; ++j) {
			R.add(j, arr.get(m + 1 + j));
		}
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			int result = L.get(i).getShelf().compareTo(R.get(j).getShelf());
			if (result < 0) {
				arr.set(k, L.get(i));
				i++;
			} else if (result == 0) {
				result = L.get(i).getIsbn() - R.get(j).getIsbn();
				if (result <= 0) {
					arr.set(k, L.get(i));
					i++;
				} else {
					arr.set(k, R.get(j));
					j++;
				}
			} else {
				arr.set(k, R.get(j));
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr.set(k, L.get(i));
			i++;
			k++;
		}
		while (j < n2) {
			arr.set(k, R.get(j));
			j++;
			k++;
		}
		return arr;
	}

	/**
	 * Name: bubbleSort
	 * sorts books by using bubbleSort
	 * @param books the ArrayList of Book to be sorted
	 * @return books, sorted
	 */
	private ArrayList<Book> bubbleSort(ArrayList<Book> books) {
		Book aux;
		for (int i = 0; i < books.size() - 1; i++) {
			for (int j = 0; j < books.size() - i - 1; j++) {
				int result = books.get(j).getShelf().compareTo(books.get(j + 1).getShelf());
				if (result > 0) {
					aux = books.get(j);
					books.set(j, books.get(j + 1));
					books.set(j + 1, aux);
				} else if (result == 0) {
					result = books.get(j).getIsbn() - books.get(j + 1).getIsbn();
					if (result > 0) {
						aux = books.get(j);
						books.set(j, books.get(j + 1));
						books.set(j + 1, aux);
					}
				}
			}
		}
		return books;
	}

	/**
	 * Name: heapSort
	 * sorts books using heap sort, method adapted from GeeksForGeeks https://www.geeksforgeeks.org/heap-sort/
	 * @param books ArrayList of Book to be sorted
	 * @return books, sorted
	 */
	private ArrayList<Book> heapSort(ArrayList<Book> books) {
		int n = books.size();
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(books, n, i);
		for (int i = n - 1; i > 0; i--) {
			Book temp = books.get(0);
			books.set(0, books.get(i));
			books.set(i, temp);
			heapify(books, i, 0);
		}
		return books;
	}

	/**
	 * Name: heapify
	 * auxiliary method of heap sort, method adapted from GeeksForGeeks https://www.geeksforgeeks.org/heap-sort/
	 * @param books ArrayList of Book
	 * @param n an int
	 * @param i an int
	 * @return books, sorted
	 */
	private ArrayList<Book> heapify(ArrayList<Book> books, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < n) {
			if (books.get(l).getShelf().compareTo(books.get(largest).getShelf()) > 0)
				largest = l;
			else if (books.get(l).getShelf().compareTo(books.get(largest).getShelf()) == 0) {
				if (books.get(l).getIsbn() - (books.get(largest).getIsbn()) > 0)
				largest = l;
			}
		}
		if (r < n) {
			if (books.get(r).getShelf().compareTo(books.get(largest).getShelf()) > 0)
				largest = r;
			else if (books.get(r).getShelf().compareTo(books.get(largest).getShelf()) == 0) {
				if (books.get(r).getIsbn() - (books.get(largest).getIsbn()) > 0)
					largest = r;
			}
		}
		if (largest != i) {
			Book swap = books.get(i);
			books.set(i, books.get(largest));
			books.set(largest, swap);
			heapify(books, n, largest);
		}
		return books;
	}

	/**
	 * Name: createShelves
	 * creates the number of shelves given, assigns an identifier (uppercase letter) alphabetically, A through Z, AA after Z and so on
	 * @param numberOfS an int
	 */
	public void createShelves(int numberOfS) {
		int nPrevLetter = 0;
		int index = 90;
		while (numberOfS > 0) {
			char prevLetter = (char) index;
			String prevLetters = "";
			for (int i = 0; i < nPrevLetter; i++)
				prevLetters += prevLetter;
			for (int i = 65; i < 91 && numberOfS > 0; i++) {
				char letter = (char) i;
				shelves.add(new Shelf<Integer, Book>(prevLetters + letter));
				--numberOfS;
			}
			if (index == 90) {
				nPrevLetter++;
				index = 65;
			} else
				index++;
		}
	}

	/**
	 * Name: getNumberOfShelves
	 * gets the number of shelves
	 * @return an int
	 */
	public int getNumberOfShelves() {
		return shelves.size();
	}

	/**
	 * Name: getIdentifiers
	 * gets the identifiers of the shelves created
	 * @return a String[] containing the Identifiers of the shelves
	 */
	public String[] getIdentifiers() {
		String identifiers[] = new String[shelves.size()];
		for (int i = 0; i < shelves.size(); i++)
			identifiers[i] = shelves.get(i).getIdentifier();
		return identifiers;
	}

	/**
	 * Name: getNumberOfClients
	 * gets the number of clients
	 * @return an int
	 */
	public int getNumberOfClients() {
		return clients.size();
	}

	/**
	 * Name: getIds
	 * gets the IDs of the clients
	 * @return a String[] containing the IDs of the clients
	 */
	public String[] getIds() {
		String ids[] = new String[clients.size()];
		for (int i = 0; i < clients.size(); i++)
			ids[i] = clients.get(i).getId();
		return ids;
	}

	/**
	 * Name: giveResult
	 * simulates the different sections of the bookstore and returns the information of the results of each section in a String
	 * @param typeOfSort the type of sort to be used to organize the clients' books
	 * @return a String containing the results of each section
	 * @throws MyQueueException if an instance of MyQueue was empty during the procedure and an attempt was made to get elements from it
	 * @throws MyStackException if an instance of MyStack was empty during the procedure and an attempt was made to get elements from it
	 */
	public String giveResult(char typeOfSort) throws MyQueueException, MyStackException {
		String info = "";
		ArrayList<Client> clientsDeparture = new ArrayList<>();
		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i).getISBNList().size() == 0)
				clients.remove(i);
		}
		info += "Section 1 results:\n";
		info += simulateFirstSection();
		info += "------------------------------------\nSection 2 results:\n";
		info += simulateSecondSection(typeOfSort);
		info += "------------------------------------\nSection 3 results:\n";
		info += simulateThirdSection();
		info += "------------------------------------\nSection 4 results:\n";
		simulateFourthSection(clientsDeparture);
		for (int i = 0; i < clientsDeparture.size(); i++)
			info += clientsDeparture.get(i).toString();
		return info;
	}

	/**
	 * Name: simulateFirstSection
	 * simulates the first section
	 * @return a String containing the clients and their lists of books, unorganized
	 */
	public String simulateFirstSection() {
		String info = "";
		for (int i = 0; i < clients.size(); i++) {
			Client currentClient = clients.get(i);
			info += "\nClient " + (i + 1) + ":\n" + currentClient.getId() + "\n";
			info += "List of Books:\n" + currentClient.getBookList();
		}
		return info;
	}

	/**
	 * Name: simulateSecondSection
	 * simulates the second section of the Bookstore
	 * @param orderBy the method to be used to sort the clients' list of books (B, H or M)
	 * @return a String containing the clients and their lists of books, organized
	 */
	public String simulateSecondSection(char orderBy) {
		String info = "";
		for (int i = 0; i < clients.size(); i++) {
			Client currentClient = clients.get(i);
			info += "\nClient " + (i + 1) + ":\n" + currentClient.getTime() + " min\n" + currentClient.getId() + "\n";
			orderClientsBooks(orderBy, currentClient);
			info += "List of Books:\n" + currentClient.getBookList();
		}
		return info;
	}

	/**
	 * Name: simulateThirdSection
	 * simulates the third section
	 * @return a String containing what the clients have in their baskets
	 */
	public String simulateThirdSection() {
		String info = "";
		for (int i = 0; i < clients.size(); i++) {
			Client currentClient = clients.get(i);
			MyStack<Book> basket = currentClient.getBasket();
			for (int j = 0; j < currentClient.getISBNList().size(); j++) {
				Book temp = searchBook(currentClient.getISBNList().get(j));
				if (temp.getCopies() > 0) {
					basket.push(temp);
					temp.decreaseCopies();
				}
			}
			currentClient.setTime(currentClient.getTime() + basket.getLength());
		}
		Collections.sort(clients, new Comparator<Client>() {

			@Override
			public int compare(Client c1, Client c2) {
				int comp = c1.getTime() - c2.getTime();
				if (comp == 0)
					comp = clients.indexOf(c1) - clients.indexOf(c2);
				return comp;
			}
		});
		for (int i = 0; i < clients.size(); i++) {
			Client currentClient = clients.get(i);
			info += "\nClient " + (i + 1) + ":\n" + currentClient.getTime() + " min\n" + currentClient.getId() + "\n";
			info += "Basket:\n" + currentClient.getBasket().toString() + "\n";
		}
		return info;
	}

	/**
	 * Name: simulateFourthSection
	 * simulates the fourth section
	 * @param clientsDeparture an ArrayList of Client where the clients who are done will be stored
	 * @throws MyQueueException if an instance of MyQueue was empty during the procedure and an attempt was made to get elements from it
	 * @throws MyStackException if an instance of MyStack was empty during the procedure and an attempt was made to get elements from it
	 */
	public void simulateFourthSection(ArrayList<Client> clientsDeparture) throws MyQueueException, MyStackException {
		MyQueue<Client> line = new MyQueue<>(clients);
		boolean stop = false;
		while (line.getLength() > 0 || !stop) {
			for (int i = 0; i < cashiers.length; i++) {
				if (cashiers[i].isFree() && line.getLength() > 0)
					cashiers[i].setCurrentClient(line.dequeue());
				else {
					if (cashiers[i].getCurrentClient() != null) {
						cashiers[i].registerBook();
						if (cashiers[i].getCurrentClient().getBasket().isEmpty())
							clientsDeparture.add(cashiers[i].sayByeToClient());
					}
				}
			}
			stop = true;
			for (int i = 0; i < cashiers.length && stop; i++) {
				if (!cashiers[i].isFree())
					stop = false;
			}
		}
	}
}