package book.management.system.app.exception;

public class PasswordMisMatchException extends RuntimeException{

	public PasswordMisMatchException() {
		
		super();
	}
	
	public PasswordMisMatchException(String message) {
		
		super(message);
	}
}
