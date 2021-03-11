package book.management.system.app.repos;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import book.management.system.app.entities.Book;
import book.management.system.app.entities.Category;


@Repository
public interface IBookRepository extends JpaRepository<Book,Integer>{


	public Book findByTitleAndAuthor(String title,String author);
	

	public List<Book> findByCategory(Category category);
	public Book findByTitle(String title);
	public Book findById(int id);
	
	//@Query("Select od.book from OrderDetails od group by book having sum(quantity) in (select max(sum) from (select sum(quantity) from OrderDetails group by book) as sums )")
	
	@Query(value = " select * from book where book.book_id in (select book_book_id as book_id from Order_details group by book_book_id having sum(quantity) in (select max(sum) from (select sum(quantity) from Order_details group by book_book_id) as sums))",nativeQuery = true)
	public List<Book> listBestSellingBooks();
	
	@Query(value="select * from book where book_id in (select book_book_id as book_id from review group by book_book_id having avg(Cast(rating AS Float)) in ( select max(average) from (select avg(Cast(rating AS Float)) as average from review group by book_book_id order by average desc) as average))",nativeQuery = true)
	public List<Book> listMostFavoredBooks();
	// select book_book_id from Order_details group by book_book_id having sum(quantity) in (select max(sum) from (select sum(quantity) from Order_details group by book_book_id) as sums);
	
}
