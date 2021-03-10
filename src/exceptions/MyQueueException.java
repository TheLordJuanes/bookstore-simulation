/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package exceptions;

public class MyQueueException extends Exception {

	// -----------------------------------------------------------------
	// Constants
    // -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// Methods
    // -----------------------------------------------------------------

	/**
	 * Name: MyQueueException
	 * Constructor method of an exception from my queue.
	 * @param message - MyQueueException's message - message = String, message != null, message != ""
	*/
	public MyQueueException(String message) {
		super(message);
	}
}