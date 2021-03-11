package book.management.system.app.repos;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import book.management.system.app.entities.Book;
import book.management.system.app.entities.Customer;
//import book.management.system.app.entities.Book;
//import book.management.system.app.entities.Customer;
import book.management.system.app.entities.Review;


@Repository
public interface IReviewRepository extends JpaRepository<Review,Integer>{

	public Review findById (int id);
	
	public Review findByCustomerAndBook (Customer customer, Book book);
	
	public List<Review> findByBook(Book book);
	public List<Review> findByCustomer(Customer customer);
	
	@Query(value="select * from book where book_id in (select book_book_id as book_id from review group by book_book_id having avg(Cast(rating AS Float)) in ( select max(average) from (select avg(Cast(rating AS Float)) as average from review group by book_book_id order by average desc) as average))",nativeQuery = true)
	public List<Book> listMostFavoredBooks();
	
	
}