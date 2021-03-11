package book.management.system.app.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	private String title;
	private String author;
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;
	private String description;
	private String isbn;
	private String price;
	private LocalDate publishedDate;
	private LocalDate lastUpdatedOn;
	
	public Book() {
		
	}

	public Book(String title, String author, Category category, String description, String isbn, String price,
			LocalDate publishedDate, LocalDate lastUpdatedOn) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.description = description;
		this.isbn = isbn;
		this.price = price;
		this.publishedDate = publishedDate;
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public LocalDate getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(LocalDate lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", description=" + description + ", isbn=" + isbn + ", price=" + price + ", publishedDate="
				+ publishedDate + ", lastUpdatedOn=" + lastUpdatedOn + "]";
	}
	
	
	
	
}
