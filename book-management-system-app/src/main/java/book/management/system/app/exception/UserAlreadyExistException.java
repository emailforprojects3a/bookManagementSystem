package book.management.system.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class UserAlreadyExistException extends RuntimeException {
	
	public UserAlreadyExistException() {
		
		super();
	}
	
	public UserAlreadyExistException(String message) {
		
		super(message);
	}

}
