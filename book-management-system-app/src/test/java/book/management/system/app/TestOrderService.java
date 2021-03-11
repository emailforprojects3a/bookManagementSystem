package book.management.system.app;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import book.management.system.app.entities.Book;
import book.management.system.app.entities.Customer;
import book.management.system.app.entities.OrderDetails;
import book.management.system.app.repos.IBookRepository;
import book.management.system.app.repos.ICustomerRepository;
import book.management.system.app.repos.IOrderRepository;
import book.management.system.app.service.OrderService;



@SpringBootTest
@RunWith(SpringRunner.class)
public class TestOrderService {

	@Autowired
	OrderService orderService;
	
	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	IOrderRepository orderRepository;
	
	@Autowired
	IBookRepository bookRepositoty;
	
	
//	@Test
	public void testListAllOrder() {
		
		System.out.println( orderService.listAllOrders());
	}
	
//	@Test
	public void testListOrderByCustomer() {
		
		Customer cs = customerRepository.findByEmail("email@email.com");
		System.out.println(orderService.listOrderByCustomer(cs));
		
		
	}
	
//	@Test
	public void testCancelOrder() {
		
		OrderDetails od = new OrderDetails();
		
		od = orderRepository.findById(10);
		orderService.cancelOrder(od);
		
	}
	
//	@Test
	public void testAddOrder() {
		
		OrderDetails od = new OrderDetails();
		od.setBook(null);
		od.setBookOrder(null);
		od.setQuantity(10);
		od.setSubtotal(100);
		
		orderService.addOrder(od);
	}
	
//	@Test
	public void testUpdateOrder() {
		
		OrderDetails od = orderRepository.findById(26);
		od.setQuantity(12);
		orderService.updateOrder(od);
	}
	
	@Test
	public void testViewOrderByBook() {
		
		Book b = bookRepositoty.findById(4);
		
		System.out.println (orderService.viewOrderByBook(b));
	}
}
