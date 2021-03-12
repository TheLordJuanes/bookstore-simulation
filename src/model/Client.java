/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package model;

public class Client {

	// -----------------------------------------------------------------
	// Attributes
    // -----------------------------------------------------------------

	private String id;
	private int time;

	// -----------------------------------------------------------------
	// Methods
    // -----------------------------------------------------------------

	/**
	 * Name: Client
	 * Constructor method of a client.
	 * @param id - client's ID - id = String, id != null, id != ""
	 * @param time - time taken for a client in sections 2 and 3 - time = int, time != null, time != 0
	*/
	public Client(String id, int time) {
		this.id = id;
		this.time = time;
	}
	
	//Discutir
	public Client(String id) {
		this.id = id;
	}

	public String toString() {
		return "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}