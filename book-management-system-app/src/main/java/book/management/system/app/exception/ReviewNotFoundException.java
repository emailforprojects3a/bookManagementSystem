package book.management.system.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ReviewNotFoundException extends RuntimeException{
	
	public ReviewNotFoundException() {
		
		super();
	}
	
	public ReviewNotFoundException(String message) {
		
		super(message);
	}

}
