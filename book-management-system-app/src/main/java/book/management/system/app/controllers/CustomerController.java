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
import book.management.system.app.exception.CustomerAlreadyExistException;
import book.management.system.app.exception.CustomerNotFoundException;
import book.management.system.app.repos.ICustomerRepository;
import book.management.system.app.service.BookService;
import book.management.system.app.service.OrderService;
import book.management.system.app.service.ReviewService;

@RestController
public class CustomerController {

	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	BookService bookService;

	@PostMapping("/customers")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Customer createCustomer(@RequestBody Customer c) {
		
		Customer customer = customerRepository.findByEmail(c.getEmail());
		
		if(customer == null)
			return customerRepository.save(c);
		else
			throw new CustomerAlreadyExistException("Customer with the email " + c.getEmail() + " already exist");
		
	}
	
	@GetMapping("/customers/list")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Customer> listCustomers(){
		
		List<Customer> list = customerRepository.findAll();
		if(list.isEmpty())
			throw new CustomerNotFoundException("There is no customer in the repository");
		
		return list;
	}
	
	@DeleteMapping("/customers/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Customer deleteCustomer(@RequestBody Customer c) {
		
		Customer customer  = customerRepository.findById(c.getCustomerId());
		
		if(customer == null)
			throw new CustomerNotFoundException("There is no customer in the repository to delete with the id " + c.getCustomerId());
				
		else {
			reviewService.deleteReviewOfCustomer(customer);
			orderService.deleteOrderOfCustomer(customer);
			customerRepository.delete(customer);
		}
			
		return customer;
	}
	
	@GetMapping("/customers/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public Customer viewCustomer(@RequestBody Customer c) {
		
		Customer customer = customerRepository.findById(c.getCustomerId());
		
		if(customer == null) 
			throw new CustomerNotFoundException("There is no customer in the repository with the id " + c.getCustomerId());
		
		return customer;
	}
	
//	public Optional<Customer> viewCustomer(int c) {
//		
//		Optional<Customer> customer = customerRepository.findById(c);
//		
//		if(!customer.isPresent()) 
//			throw new CustomerNotFoundException("There is no customer in the repository with the id " + c);
//		
//		return customer;
//	}
	
	@PutMapping("/customers/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Transactional
	public Customer updateCustomer(@RequestBody Customer c) {
//		
//		Customer customer = customerRepository.findByEmail(c.getEmail());
//		
//		if(customer==null) 
//			throw new BookNotFoundException("There is no customer in the repository with the email" + c.getEmail());
//			
//		else
//			customer.setMobileNumber(c.getMobileNumber());
			
		
		return customerRepository.save(c);
	}

	@GetMapping("/customers/book/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Customer> listAllCustomersByBook(@RequestBody Book b) {
		
		Book book = bookService.viewBook(b);
		
		List<Customer> list = customerRepository.listByBook(book);
		
		return list;
	}
}
