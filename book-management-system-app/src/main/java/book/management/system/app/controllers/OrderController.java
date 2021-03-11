package book.management.system.app.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import book.management.system.app.entities.Book;
import book.management.system.app.entities.Customer;
import book.management.system.app.entities.OrderDetails;
import book.management.system.app.exception.OrderNotFoundException;
import book.management.system.app.repos.IOrderRepository;
import book.management.system.app.service.BookService;
import book.management.system.app.service.CustomerService;

@RestController
public class OrderController {

	@Autowired
	IOrderRepository orderRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/orders/list")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<OrderDetails> listAllOrders() {
		
		List<OrderDetails> list = orderRepository.findAll();
		return list;
	}

	@GetMapping("/orders/customer/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<OrderDetails> listOrderByCustomer(@RequestBody Customer c) {
		
		Customer customer = customerService.viewCustomer(c);
		
		List<OrderDetails> orderList = orderRepository.findByCustomer(customer);
		return orderList;
	}

	
	public OrderDetails viewOrderForCustomer(OrderDetails od) {
		// TODO Auto-generated method stub
		return null;
	}


	public OrderDetails viewOrderForAdmin(OrderDetails od) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("/orders/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public OrderDetails cancelOrder(@RequestBody OrderDetails od) {
		
		OrderDetails orderDetail = orderRepository.findById(od.getId());
		
		if(orderDetail == null)
			throw new OrderNotFoundException("No order found");
		
		else
			orderRepository.delete(orderDetail);
		
		return orderDetail;
	
	}

	@PostMapping("/orders")
	@ResponseStatus(code = HttpStatus.CREATED)
	public OrderDetails addOrder(OrderDetails od) {

//		OrderDetails order = orderRepository.findById(od.getId());
//		
//		if(order == null) {
//		
//			orderRepository.save(od);
//			
//		}
//		
//		else
//			throw new OrderAlreadyExistException("This order already exist");
		
		return orderRepository.save(od);
	}

	@PutMapping("/orders/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Transactional
	public OrderDetails updateOrder(OrderDetails od) {

//		OrderDetails orderDetail = orderRepository.findById(od.getId());
//		
//		if(orderDetail == null)
//			throw new OrderNotFoundException("No order found");
//		else
//			orderDetail.setQuantity(od.getQuantity());
		
		return orderRepository.save(od);
	}

	@GetMapping("/orders/book/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<OrderDetails> viewOrderByBook(Book book) {
		
		Book b = bookService.viewBook(book);
		List<OrderDetails> orderList = orderRepository.findByBook(b);
		if(orderList==null)
			throw new OrderNotFoundException("No order found");
		
		return orderList;
	}

}
