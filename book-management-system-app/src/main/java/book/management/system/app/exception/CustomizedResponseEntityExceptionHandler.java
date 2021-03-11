package book.management.system.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BookAlreadyExistException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(BookAlreadyExistException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}
	@ExceptionHandler(CategoryAlreadyExistException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(CategoryAlreadyExistException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}
	@ExceptionHandler(BookNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(BookNotFoundException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(CategoryNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(CategoryNotFoundException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(CustomerAlreadyExistException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(CustomerAlreadyExistException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(CustomerNotFoundException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(OrderAlreadyExistException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(OrderAlreadyExistException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}


	@ExceptionHandler(OrderNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(OrderNotFoundException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(PasswordMisMatchException.class)
	public final ResponseEntity<Object> handleValidationException(PasswordMisMatchException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);

	}
	@ExceptionHandler(ReviewAlreadyExistException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(ReviewAlreadyExistException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}
	@ExceptionHandler(ReviewNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(ReviewNotFoundException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(UserAlreadyExistException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleNotAUserException(UserNotFoundException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

	}

}