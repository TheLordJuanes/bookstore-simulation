package model;

public class Client {

	private String id;
	private int time;

	/**
	 *
	 * @param id
	 * @param time
	 */
	public Client(String id, int time) {
		this.id = id;
		this.time = time;
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