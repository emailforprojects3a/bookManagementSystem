package book.management.system.app;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import book.management.system.app.entities.Book;
import book.management.system.app.entities.Customer;
import book.management.system.app.entities.Review;
import book.management.system.app.repos.IBookRepository;
import book.management.system.app.repos.ICustomerRepository;
import book.management.system.app.repos.IReviewRepository;
import book.management.system.app.service.ReviewService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestReviewService {

	@Autowired
	ReviewService reviewService;
	
	@Autowired
	IReviewRepository reviewRepository;
	
	@Autowired
	IBookRepository bookRepository;
	
	@Autowired
	ICustomerRepository customerRepository;
	
//	@Test
	public void testListAllReviews() {
		
		System.out.println(reviewService.listAllReviews());
	}
	
	@Test
	public void testAddReview() {
		
		Customer c = new Customer();
		c.setCustomerId(24);
		c.setEmail("abc@abc.com");
		Book b = new Book();
		b.setBookId(8);
		
		Review rev = new Review();
		rev.setBook(b);
		rev.setComment("Good");
		rev.setCustomer(c);
		rev.setHeadLine("Must read");
		rev.setRating("5");
		rev.setReviewOn(LocalDate.of(2018, 10, 10));
		
		reviewService.addReview(rev);
		
	}
	
	
//	@Test
	public void testUpdateReview() {
		
		Review rev = reviewRepository.findById(36);
		rev.setComment("This is updated");
		reviewService.updateReview(rev);
	}
	
	//@Test
	public void testDeleteReview() {
		
		Review rev = reviewRepository.findById(35);
		reviewService.deleteReview(rev);
	}
	
//	@Test
	public void testViewReview() {
		
		Review rev = reviewRepository.findById(31);
		
		System.out.println(reviewService.viewReview(rev));
	}
	
//	@Test
	public void testListAllReviewsByBook() {
		
		Book b = bookRepository.findById(4);
		System.out.println(reviewService.listAllReviewsByBook(b));
	}
	
//	@Test
	public void testListAllReviewsByCustomer() {
		
		Customer cs = customerRepository.findById(8);
		System.out.println(reviewService.listAllReviewByCustomer(cs));
	}
	
	//@Test
	public void testListMostFavoredBooks() {
		
		
		System.out.println(reviewService.listMostFavoredBooks());
	}
}
