package book.management.system.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.management.system.app.entities.Book;
import book.management.system.app.entities.Customer;
import book.management.system.app.exception.CustomerAlreadyExistException;
import book.management.system.app.exception.CustomerNotFoundException;
import book.management.system.app.repos.ICustomerRepository;
import book.management.system.app.serviceInterface.ICustomerService;

@Service
public class CustomerService implements ICustomerService{
	
	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	BookService bookService;

	public Customer createCustomer(Customer c) {
		
		Customer customer = customerRepository.findByEmail(c.getEmail());
		
		if(customer == null)
			return customerRepository.save(c);
		else
			throw new CustomerAlreadyExistException("Customer with the email " + c.getEmail() + " already exist");
		
	}
	
	public List<Customer> listCustomers(){
		
		List<Customer> list = customerRepository.findAll();
		if(list.isEmpty())
			throw new CustomerNotFoundException("There is no customer in the repository");
		
		return list;
	}
	
	public Customer deleteCustomer(Customer c) {
		
		Customer customer  = customerRepository.findById(c.getCustomerId());
		
	    if(customer == null)
			throw new CustomerNotFoundException("There is no customer in the repository to delete with the id " + c);
				
		else
		{
			reviewService.deleteReviewOfCustomer(customer);
			orderService.deleteOrderOfCustomer(customer);
			customerRepository.delete(customer);
		}
			
			
		return customer;
	}
	
	public Customer viewCustomer(Customer c) {
		
		Customer customer = customerRepository.findById(c.getCustomerId());
		
		if(customer == null) 
			throw new CustomerNotFoundException("There is no customer in the repository with the id " + c);
		
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
	
	@Transactional
	public Customer updateCustomer(Customer c) {
		
//		Customer customer = customerRepository.findByEmail(c.getEmail());
//		
//		if(customer==null) 
//			throw new BookNotFoundException("There is no customer in the repository with the email" + c.getEmail());
//			
//		else
//			customer.setMobileNumber(c.getMobileNumber());
			
		
		return customerRepository.save(c);
	}

	@Override
	public List<Customer> listAllCustomersByBook(Book b) {
		
		Book book = bookService.viewBook(b);
		
		List<Customer> list = customerRepository.listByBook(book);
		
		return list;
	}

	
	

}
