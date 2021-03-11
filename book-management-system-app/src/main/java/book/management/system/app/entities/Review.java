package book.management.system.app.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reviewId;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Book book;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Customer customer;
	private String headLine;
	private String comment;
	private String rating;
	private LocalDate reviewOn;
	
	
	public Review() {
		
	}


	public Review(Book book, Customer customer, String headLine, String comment, String rating, LocalDate reviewOn) {
		super();
		this.book = book;
		this.customer = customer;
		this.headLine = headLine;
		this.comment = comment;
		this.rating = rating;
		this.reviewOn = reviewOn;
	}


	public int getReviewId() {
		return reviewId;
	}


	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public String getHeadLine() {
		return headLine;
	}


	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public LocalDate getReviewOn() {
		return reviewOn;
	}


	public void setReviewOn(LocalDate reviewOn) {
		this.reviewOn = reviewOn;
	}


	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", book=" + book + ", customer=" + customer + ", headLine=" + headLine
				+ ", comment=" + comment + ", rating=" + rating + ", reviewOn=" + reviewOn + "]";
	}
	
	
}
