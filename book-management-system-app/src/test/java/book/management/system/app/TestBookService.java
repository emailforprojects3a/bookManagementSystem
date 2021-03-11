package book.management.system.app;

//import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;
//import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import book.management.system.app.entities.Book;
import book.management.system.app.entities.Category;
import book.management.system.app.repos.IBookRepository;
import book.management.system.app.service.BookService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestBookService {
	
	
	@Autowired
	BookService bookService;
	
	@Autowired
	IBookRepository bookRepository;
	
	
	
	@Test
	public void testCreateBook() {
		
		Book b = new Book();
		Category cat = new Category();
		cat.setCategoryName("Fiction");
		
		b.setTitle("Lord of the ring : Undisputed");
		b.setAuthor("ABC");
		b.setCategory(cat);
		b.setDescription("Story of evil ring");
		b.setIsbn("ABC123");
		b.setPrice("100.00");
		b.setPublishedDate(LocalDate.of(2001, 03, 10));
		b.setLastUpdatedOn(LocalDate.now());
		
		
//		Book b1 = new Book();
//	
//		b1.setTitle("Harry Potter");
//		b1.setAuthor("ABC");
//		b1.setCategory(cat);
//		b1.setDescription("Story of magic");
//		b1.setIsbn("ABC123");
//		b1.setPrice("100.00");
//		b1.setPublishedDate(LocalDate.of(2001, 03, 10));
//		b1.setLastUpdatedOn(LocalDate.now());

		
//		bookService.createBook(b);
//		bookService.createBook(b1);
//		assertEquals(2, bookRepository.count());
		
//		Book book = new Book();
//		book.setBookId(100);
//		book.setAuthor("abbvbv");
		bookService.createBook(b);
		
	}
	
	
//	@Test
	public void testListAllBook() {
		
		List<Book> mylist = bookService.listAllBook();
		System.out.println(mylist);
	}
	
//	@Test
	public void testDeleteBook() {
		
		Book b = bookRepository.findById(20);
//		Optional<Book> b = bookService.viewBook(6);
		bookService.deleteBook(b);

	}
	
//	@Test
	public void testEditBook() {
		
//		Book book = bookRepository.findByTitle("Harry Potter");
		Book b = bookRepository.findById(21);
		b.setAuthor("J.K R");
		bookService.editBook(b);
	}
	
//	@Test
	public void testViewBook() {
		
		Book book = bookRepository.findByTitle("Harry Potter");
		System.out.println(bookService.viewBook(book));
		
	}
	
	//@Test
	public void testListBooksByCategory() {
		
		List<Book> books  = bookService.listBooksByCategory("Fiction");
		System.out.println(books);
	}
	
	//@Test
	public void testListBestSellingBook() {
		
		
		System.out.println(bookService.listBestSellingBook());
		
	}
	
	

}
