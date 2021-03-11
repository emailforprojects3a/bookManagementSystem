package book.management.system.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {
	
	public CategoryNotFoundException() {
		
		super();
	}
	
	public CategoryNotFoundException(String message) {
		
		super(message);
	}

}
