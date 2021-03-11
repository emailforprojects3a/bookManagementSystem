package book.management.system.app.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import book.management.system.app.entities.Book;
import book.management.system.app.entities.Category;
import book.management.system.app.exception.BookAlreadyExistException;
import book.management.system.app.exception.BookNotFoundException;
import book.management.system.app.exception.CategoryNotFoundException;
import book.management.system.app.repos.IBookRepository;
import book.management.system.app.repos.ICategoryRepository;

@RestController
public class BookController {

	
	@Autowired
	IBookRepository  bookRepository;
	
	@Autowired
	ICategoryRepository categoryRepository;
	
	
	@PostMapping("/books")
	@ResponseStatus(code = HttpStatus.CREATED)
	@Transactional
	public Book createBook(@RequestBody Book b)
	{
	
		Book book = bookRepository.findByTitleAndAuthor(b.getTitle(),b.getAuthor());
		
		Category c = categoryRepository.findByCategoryName(b.getCategory().getCategoryName());
				
		if(c!=null)
			b.setCategory(c);
		
		if(book!= null) 
			throw new BookAlreadyExistException("Book with title " + b.getTitle() + " by the author " + b.getAuthor() + " already exist");
	
		return bookRepository.save(b);
		
	}
	
	@GetMapping("/books/list")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Book> listAllBook(){
		
		List<Book> list = bookRepository.findAll();
		
		if(list.isEmpty())
			throw new BookNotFoundException("There is no book in the repository");
		
		return list;
		
	}
	
	@DeleteMapping("/books/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Book deleteBook(@RequestBody Book b) {
		
		Book book  = bookRepository.findById(b.getBookId());
			
		if(book ==null)
			throw new BookNotFoundException("There is no book in the repository to delete with the id " + b.getBookId());
		
		else
			bookRepository.delete(book);
		
		return book;
	}
	
	@PutMapping("/books")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Transactional
	public Book editBook(@RequestBody Book b) {
		
//		Book book = bookRepository.findById(b.getBookId());
//		
//		if(book == null) 
//			throw new BookNotFoundException("There is no book in the repository with the id " + b.getBookId());
//		else {
//			book.setAuthor(b.getAuthor());
//		}
				
		return bookRepository.save(b);
	}
	
	@GetMapping("/books/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public Book viewBook(@RequestBody Book b) {
		
		Book book = bookRepository.findById(b.getBookId());
		
		if(book ==null) 
			throw new BookNotFoundException("There is no book in the repository with the id " + b.getBookId());
		
		return book;
	}
	
//	public Optional<Book> viewBook(int b) {
//		
//		Optional<Book> book = bookRepository.findById(b);
//		
//		if(!book.isPresent()) 
//			throw new BookNotFoundException("There is no book in the repository with the id " + b);
//		
//		return book;
//	}
	
	@GetMapping("/books/category/{categoryName}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Book> listBooksByCategory(@PathVariable String categoryName){
		
		Category cat = categoryRepository.findByCategoryName(categoryName);
		
		if(cat==null)
			throw new CategoryNotFoundException("There is no such category with the name " + categoryName);
		
		List<Book> book  = bookRepository.findByCategory(cat);
		
		if(book.isEmpty())
			throw new BookNotFoundException("There is no book in the category " + categoryName);
		
		return book;
		
	}
	@GetMapping("/books/best")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Book> listBestSellingBook() {
		
		return bookRepository.listBestSellingBooks();
	}
	
}
