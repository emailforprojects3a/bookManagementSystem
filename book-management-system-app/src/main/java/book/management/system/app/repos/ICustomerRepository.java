package book.management.system.app.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import book.management.system.app.entities.Book;
import book.management.system.app.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer>{


	public Customer findByEmail(String email);
	public Customer findById(int id);
	
	@Query("Select od.bookOrder.customer from OrderDetails od where od.book=:book")
	public List<Customer> listByBook(@Param("book") Book book);
	
}
