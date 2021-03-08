package exceptions;

public class MyQueueException extends Exception {

	private static final long serialVersionUID = 1L;

	public MyQueueException(String msg) {
		super(msg);
	}
}