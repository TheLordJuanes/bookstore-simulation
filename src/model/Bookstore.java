/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package model;

import java.util.ArrayList;

public class Bookstore {

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	private ArrayList<Shelf<Integer, Double>> shelves;
	private ArrayList<Client> clients;
	private int numberOfCashiers;

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
		//shelves.add(null); discutir
	}

	public void addBook(String bIsbn, String numberOfCopies, char bookShelf, double bookPrice) {

	}
	
	public boolean addClient(String id) {
		boolean exist = false;
		for(int i=0; i<clients.size() && !exist; i++) {
			if(clients.get(i).getId().equals(id)) {
				exist=true;
			}
		}
		if(!exist) {
			clients.add(new Client(id));
		}
		return exist;
	}

	public void orderClientsBooks() {
	}

	public Book searchBook() {
		return null;
	}

	public void orderClientsByTime() {
	}

	public void simulatePayment() {
	}

	public double calculatePayment() {
		return 0;
	}

	public String[] resultsReport() {
		return null;
	}
	
	public void createShelves(int numberOfS) {
		int nPrevLetter=0;
		int index=90;
		while(numberOfS>0) {
			char prevLetter=(char)index;
			String prevLetters="";
			for(int i=0; i<nPrevLetter; i++) {
				prevLetters+=prevLetter;
			}
			for(int i=65; i<91 && numberOfS>0; i++) {
				char letter = (char)i;
				shelves.add(new Shelf<Integer, Double>(prevLetters+letter));
				--numberOfS;
			}
			if(index==90) {
				nPrevLetter++;
				index=65;
			}else {
				index++;
			}
				
		}
		testCreateShelves();
	}
	
	public void testCreateShelves() {
		for(int i=0; i<shelves.size(); i++) {
			System.out.println(shelves.get(i).getIdentifier());
		}
		
	}

	public int getNumberOfShelves() {
		return shelves.size();
	}

	public int getNumberOfCashiers() {
		return numberOfCashiers;
	}

	public void setNumberOfCashiers(int numberOfCashiers) {
		this.numberOfCashiers = numberOfCashiers;
	}
	
	public String[] getIdentifiers() {
		String identifiers[] = new String[shelves.size()];
		for(int i=0; i<shelves.size(); i++) {
			identifiers[i]=shelves.get(i).getIdentifier();
		}
		return identifiers;
	}
	
	public int getNumberOfClients() {
		return clients.size();
	}
	
	public String[] getIds() {
		String ids[] = new String[clients.size()];
		for(int i=0; i<clients.size(); i++) {
			ids[i]=clients.get(i).getId();
		}
		return ids;
	}
	
	
}