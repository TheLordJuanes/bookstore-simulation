/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
 * @Authors: Juan Pablo Ramos, Juan Esteban Caicedo and Jose Alejandro García
 * @Date: March, 21th 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-------
*/
package exceptions;

public class MyStackException extends Exception {

	// -----------------------------------------------------------------
	// Constants
    // -----------------------------------------------------------------

    private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// Methods
    // -----------------------------------------------------------------

	/**
	 * Name: MyStackException
	 * Constructor method of an exception from my stack.
	 * @param message - MyStackException's message - message = String, message != null, message != ""
	*/
	public MyStackException(String message) {
		super(message);
	}
}