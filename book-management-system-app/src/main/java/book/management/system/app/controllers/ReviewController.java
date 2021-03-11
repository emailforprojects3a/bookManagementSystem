package book.management.system.app.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import book.management.system.app.entities.Book;
import book.management.system.app.entities.Customer;
import book.management.system.app.entities.Review;
import book.management.system.app.exception.BookNotFoundException;
import book.management.system.app.exception.ReviewAlreadyExistException;
import book.management.system.app.exception.ReviewNotFoundException;
import book.management.system.app.repos.IBookRepository;
import book.management.system.app.repos.IReviewRepository;
import book.management.system.app.service.BookService;
import book.management.system.app.service.CustomerService;

@RestController
public class ReviewController {

	@Autowired
	IReviewRepository reviewRepository;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	IBookRepository bookRepository;
	
	@GetMapping("/reviews/list")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Review> listAllReviews() {
		
		List<Review> myList = reviewRepository.findAll();
		
		if(myList == null)
			throw new ReviewNotFoundException("There is no review in the repository");
		else
			return myList;
	}

	@PostMapping("/reviews")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Review addReview(@RequestBody Review review) {
		
		Review rev = reviewRepository.findById(review.getReviewId());
		if(rev==null)
			reviewRepository.save(review);
		
		else
			throw new ReviewAlreadyExistException("This review is already exist in the repository");
		
		return review;
	}

	@PutMapping("/reviews/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Transactional
	public Review updateReview(@RequestBody Review review) {
		
//		Review rev = reviewRepository.findById(review.getReviewId());
//		
//		if(rev==null)
//			throw new ReviewNotFoundException("There is no review in the repository");
//		
//		else {
//			
//			rev.setComment(review.getComment());
//		}
		
		return reviewRepository.save(review);
	}

	@DeleteMapping("/reviews/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Review deleteReview(@RequestBody Review review) {
		
		Review rev = reviewRepository.findById(review.getReviewId());
		
		if(rev==null)
			throw new ReviewNotFoundException("There is no review in the repository");
		
		else
			reviewRepository.delete(rev);
		
		return rev;
	}

	@GetMapping("/reviews/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public Review viewReview(@RequestBody Review review) {
	
		Review rev = reviewRepository.findById(review.getReviewId());
		
		if(rev==null)
			throw new ReviewNotFoundException("There is no review in the repository");
		
		else
			return rev;
	}

	@GetMapping("/reviews/book/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Review> listAllReviewsByBook(@RequestBody Book book) {
		
		Book b = bookService.viewBook(book);
		
		List<Review> myList = reviewRepository.findByBook(b);
		if(myList == null)
			throw new ReviewNotFoundException("There is no review in the repository");
		
		return myList;
	}

	@GetMapping("/reviews/customer/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Review> listAllReviewByCustomer(@RequestBody Customer customer) {
		
		Customer cs = customerService.viewCustomer(customer);
		
		List<Review> myList = reviewRepository.findByCustomer(cs);
		if(myList == null)
			throw new ReviewNotFoundException("There is no review in the repository");
		
		return myList;
	}

	@GetMapping("/reviews/fav")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Book> listMostFavoredBooks() {

		List<Book> books = bookRepository.listMostFavoredBooks();
		
		if(books == null) {
			
			throw new BookNotFoundException("There is no book in the repository");
		}
		return books;
	}
}
