package book.management.system.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.management.system.app.entities.Book;
import book.management.system.app.entities.Category;
import book.management.system.app.exception.BookAlreadyExistException;
import book.management.system.app.exception.BookNotFoundException;
import book.management.system.app.exception.CategoryNotFoundException;
import book.management.system.app.repos.IBookRepository;
import book.management.system.app.repos.ICategoryRepository;
import book.management.system.app.serviceInterface.IBookService;



@Service
public class BookService  implements IBookService{

	@Autowired
	IBookRepository  bookRepository;
	
	@Autowired
	ICategoryRepository categoryRepository;
	
	@Autowired
	CategoryService categoryService;
	
	@Transactional
	public Book createBook( Book b)
	{
	
		Book book = bookRepository.findByTitleAndAuthor(b.getTitle(),b.getAuthor());
		
		Category c = categoryRepository.findByCategoryName(b.getCategory().getCategoryName());
		
		System.out.println(c);
		
		if(c!=null)
			b.setCategory(c);
		
		if(book != null)
			throw new BookAlreadyExistException("Book with title " + b.getTitle() + " by the author " + b.getAuthor() + " already exist");
	
		return bookRepository.save(b);
		
	}
	
	public List<Book> listAllBook(){
		
		List<Book> list = bookRepository.findAll();
		
		if(list.isEmpty())
			throw new BookNotFoundException("There is no book in the repository");
		
		return list;
		
	}
	
	
	public Book deleteBook(Book b) {
		
		Book book  = bookRepository.findById(b.getBookId());
		
		if(book == null) 
			throw new BookNotFoundException("There is no book in the repository with the id " + b.getBookId());
		else
			bookRepository.delete(book);
		
		return book;
	}
	
	@Transactional
	public Book editBook(Book b) {
		
//		Book book = bookRepository.findById(b.getBookId());
//		
//		if(book == null) 
//			throw new BookNotFoundException("There is no book in the repository with the id " + b.getBookId());
//		else {
//			book.setAuthor(b.getAuthor());
//		}
//				
//		return book;
		
		return bookRepository.save(b);
		
	}
	
	public Book viewBook(Book b) {
		
		Book book = bookRepository.findById(b.getBookId());
		
		if(book == null) 
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
	public List<Book> listBooksByCategory(String category){
		
		Category cat = categoryRepository.findByCategoryName(category);
		
		if(cat==null)
			throw new CategoryNotFoundException("There is no such category with the name " + category);
		
		List<Book> book  = bookRepository.findByCategory(cat);
		
		if(book.isEmpty())
			throw new BookNotFoundException("There is no book in the category " + category);
		
		return book;
		
	}

	@Override
	public List<Book> listBestSellingBook() {
		
		return bookRepository.listBestSellingBooks();
	}
		
		
	
}
