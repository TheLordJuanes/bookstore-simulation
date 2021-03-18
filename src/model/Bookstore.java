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

	public void addCashiers(int numberOfCashiers) {
		cashiers = new Cashier[numberOfCashiers];
		for (int i = 0; i < numberOfCashiers; i++)
			cashiers[i] = new Cashier();
	}

	public int getNumberOfCashiers(){
		return cashiers.length;
	}

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

	public void emptyClients(){
		clients.clear();
	}

	public boolean areShelvesEmpty() {
		boolean result = true;
		for (int i = 0; i < shelves.size(); i++) {
			if (!shelves.get(i).isEmpty())
				result = false;
		}
		return result;
	}

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

	public boolean checkBook(int isbn) {
		boolean found = false;
		for (int i = 0; i < shelves.size() && !found; i++) {
			if (shelves.get(i).search(isbn) != null)
				found = true;
		}
		return found;
	}

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

	public ArrayList<Book> createListBooks(ArrayList<Integer> isbnList) {
		ArrayList<Book> books = new ArrayList<Book>();
		for (int i = 0; i < isbnList.size(); i++) {
			Book found = searchBook(isbnList.get(i));
			if (found != null)
				books.add(found);
		}
		return books;
	}

	public void orderClientsBooks(char sortingAlgorithm) {
		ArrayList<Book> result;
		for (int i = 0; i < clients.size(); i++) {
			Client currentClient = clients.get(i);
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
	}

	private ArrayList<Integer> booksToISBN(List<Book> books) {
		ArrayList<Integer> isbns = new ArrayList<>();
		for (int i = 0; i < books.size(); i++)
			isbns.add(books.get(i).getIsbn());
		return isbns;
	}

	private ArrayList<Book> mergeSort(ArrayList<Book> books, int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			mergeSort(books, l, m);
			mergeSort(books, m + 1, r);
			merge(books, l, m, r);
		}
		return books;
	}

	private void merge(ArrayList<Book> books, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		ArrayList<Book> L = new ArrayList<Book>();
		ArrayList<Book> R = new ArrayList<Book>();
		for (int i = 0; i < n1; ++i)
			L.set(i, books.get(l + 1));
		for (int j = 0; j < n2; ++j) {
			R.set(j, books.get(m + 1 + j));
		}
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L.get(i).getShelf().compareTo(R.get(j).getShelf()) <= 0) {
				books.set(k, L.get(i));
				i++;
			} else {
				books.set(k, R.get(j));
				j++;
			}
			k++;
		}
		while (i < n1) {
			books.set(k, L.get(i));
			i++;
			k++;
		}
		while (j < n2) {
			books.set(k, R.get(j));
			j++;
			k++;
		}
	}

	private ArrayList<Book> bubbleSort(ArrayList<Book> books) {
		Book aux;
		for (int i = 0; i < books.size() - 1; i++) {
			for (int j = 0; j < books.size() - i - 1; j++) {
				int result = books.get(j).getShelf().compareTo(books.get(j + 1).getShelf());
				if (result > 0) {
					aux = books.get(j);
					books.set(j, books.get(j + 1));
					books.set(j + 1, aux);
				} else if (result > 0) {
					aux = books.get(j);
					books.set(j, books.get(j + 1));
					books.set(j + 1, aux);
				}
			}
		}
		return books;
	}

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

	private void heapify(ArrayList<Book> books, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < n && books.get(l).getShelf().compareTo(books.get(largest).getShelf()) > 0)
			largest = l;
		if (r < n && books.get(r).getShelf().compareTo(books.get(largest).getShelf()) > 0)
			largest = r;
		if (largest != i) {
			Book swap = books.get(i);
			books.set(i, books.get(largest));
			books.set(largest, swap);
			heapify(books, n, largest);
		}
	}

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

	public int getNumberOfShelves() {
		return shelves.size();
	}

	public String[] getIdentifiers() {
		String identifiers[] = new String[shelves.size()];
		for (int i = 0; i < shelves.size(); i++)
			identifiers[i] = shelves.get(i).getIdentifier();
		return identifiers;
	}

	public int getNumberOfClients() {
		return clients.size();
	}

	public String[] getIds() {
		String ids[] = new String[clients.size()];
		for (int i = 0; i < clients.size(); i++)
			ids[i] = clients.get(i).getId();
		return ids;
	}

	public String giveResult(char typeOfSort) throws MyQueueException, MyStackException {
		String info = "";
		ArrayList<Client> clientsDeparture = new ArrayList<>();
		info+="Section 1 results:\n";
		info += simulateFirstSection();
		info+="------------------------------------\nSection 2 results:\n";
		info += simulateSecondSection(typeOfSort);
		info+="------------------------------------\nSection 3 results:\n";
		info += simulateThirdSection()+"\n";
		info+="------------------------------------\nSection 4 results:\n";
		// info += simulateFourthSection(clientsDeparture);
		simulateFourthSection(clientsDeparture);
		for (int i = 0; i < clientsDeparture.size(); i++)
			info += clientsDeparture.get(i).toString();
		return info;
	}

	public String simulateFirstSection() {
		String info = "";
		for (int i = 0; i < clients.size(); i++) {
			Client currentClient = clients.get(i);
			info += "Client " + (i + 1) + ":\n" + currentClient.getId() + "\n";
			info += "List of Books:\n" + currentClient.getBookList();
		}
		return info;
	}

	public String simulateSecondSection(char orderBy) {
		String info = "";
		for (int i = 0; i < clients.size(); i++) {
			Client currentClient = clients.get(i);
			info += "Client " + (i + 1) + ":\n" + currentClient.getTime() + " min\n" + currentClient.getId() + "\n";
		}
		orderClientsBooks(orderBy);
		for (int i = 0; i < clients.size(); i++) {
			Client currentClient = clients.get(i);
			info += "List of Books:\n" + currentClient.getBookList();
		}
		return info;
	}

	public String simulateThirdSection() {
		String info = "";
		for (int i = 0; i < clients.size(); i++) {
			Client currentClient = clients.get(i);
			MyStack<Book> basket = currentClient.getBasket();
			for (int j = 0; j < currentClient.getISBNList().size(); j++) {
				basket.push(searchBook(currentClient.getISBNList().get(j)));
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
			info += "Client " + (i + 1) + ":\n" + currentClient.getTime() + " min\n" + currentClient.getId() + "\n";
			info += "Basket:\n" + currentClient.getBasket().toString();
		}
		return info;
	}

	public void simulateFourthSection(ArrayList<Client> clientsDeparture) throws MyQueueException, MyStackException {
		MyQueue<Client> line = new MyQueue<>(clients);
		boolean stop = false;
		while (line.getLength() > 0 || !stop) {
			for (int i = 0; i < cashiers.length; i++) {
				if (cashiers[i].isFree() && line.getLength()>0)
					cashiers[i].setCurrentClient(line.dequeue());
				else {
					if(cashiers[i].getCurrentClient()!=null) {
						cashiers[i].registerBook();
						if (cashiers[i].getCurrentClient().getBasket().isEmpty())
							clientsDeparture.add(cashiers[i].sayByeToClient());
					}
					
				}
			}
			stop=true;
			for (int i = 0; i < cashiers.length && stop; i++) {
				if(!cashiers[i].isFree()) {
					stop=false;
				}
			}
			
			
		}
	}
}