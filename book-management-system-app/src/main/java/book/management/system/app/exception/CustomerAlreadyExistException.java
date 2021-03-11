package book.management.system.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CustomerAlreadyExistException extends RuntimeException{
	
	public CustomerAlreadyExistException() {
		
		super();
	}
	
	public CustomerAlreadyExistException(String message) {
		
		super(message);
	}

}
