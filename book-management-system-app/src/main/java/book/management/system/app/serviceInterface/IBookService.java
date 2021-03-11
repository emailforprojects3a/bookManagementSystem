package book.management.system.app.serviceInterface;

import java.util.List;

import book.management.system.app.entities.Book;

public interface IBookService {

	public Book createBook(Book b);
	public List<Book> listAllBook();
	public Book deleteBook(Book b);
	public Book editBook(Book b);
	public Book viewBook(Book b);
	public List<Book> listBooksByCategory(String category);
	public List<Book> listBestSellingBook();
}
