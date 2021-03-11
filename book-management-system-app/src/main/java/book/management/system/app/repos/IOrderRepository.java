package book.management.system.app.repos;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import book.management.system.app.entities.Book;
import book.management.system.app.entities.Customer;
//import book.management.system.app.entities.Book;
//import book.management.system.app.entities.Customer;
import book.management.system.app.entities.OrderDetails;

@Repository
public interface IOrderRepository extends JpaRepository<OrderDetails,Integer>{

	public OrderDetails findById(int od);
	public List<OrderDetails> findByBook(Book b);
	
	@Query("Select od from OrderDetails od where od.bookOrder.customer =:customer")
	public List<OrderDetails> findByCustomer(@Param("customer") Customer c);
	
	
}