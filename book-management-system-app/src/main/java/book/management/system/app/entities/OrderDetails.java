package book.management.system.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne(cascade = CascadeType.ALL)
	private Book book;
	@OneToOne(cascade = CascadeType.ALL)
	private BookOrder bookOrder;
	private int quantity;
	private double subtotal;
	
	public OrderDetails() {
		
	}

	public OrderDetails(Book book, BookOrder bookOrder, int quantity, double subtotal) {
		super();
		this.book = book;
		this.bookOrder = bookOrder;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public BookOrder getBookOrder() {
		return bookOrder;
	}

	public void setBookOrder(BookOrder bookOrder) {
		this.bookOrder = bookOrder;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", book=" + book + ", bookOrder=" + bookOrder + ", quantity=" + quantity
				+ ", subtotal=" + subtotal + "]";
	}
	
	
}
