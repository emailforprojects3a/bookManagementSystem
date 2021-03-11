package book.management.system.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ReviewAlreadyExistException extends RuntimeException {

	public ReviewAlreadyExistException() {
		
		super();
	}
	
	public ReviewAlreadyExistException(String message) {
		
		super(message);
	}
}
