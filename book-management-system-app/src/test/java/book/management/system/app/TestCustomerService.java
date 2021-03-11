package book.management.system.app;


import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import book.management.system.app.entities.Address;
import book.management.system.app.entities.Book;
import book.management.system.app.entities.Customer;
import book.management.system.app.repos.IBookRepository;
import book.management.system.app.repos.ICustomerRepository;
import book.management.system.app.service.CustomerService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCustomerService {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	IBookRepository bookRepository;
	
	@Test
	public void testCreateCustomer() {
		
		Customer cs = new Customer();
		
		Address address = new Address();
		address.setAddress("136 Mayur Vihar");
		address.setCity("Delhi");
		address.setCountry("India");
		address.setPincode("101001");
		
		cs.setEmail("update from eclipse");
		cs.setMobileNumber("1234567890");
		cs.setFullName("Sandeep Singh");
		cs.setPassword("This@is@spring@boot");
		cs.setAddress(address);
		cs.setRegisterOn(LocalDate.of(2021, 3, 1));
//		
//		
//		
//		Customer cs1 = new Customer();
//		
//		Address address1 = new Address();
//		address1.setAddress("136 Vihar");
//		address1.setCity("Mumbai");
//		address1.setCountry("India");
//		address1.setPincode("201001");
//		
//		cs1.setEmail("abcdef@abc.com");
//		cs1.setMobileNumber("9876543210");
//		cs1.setFullName("Rohit Sharma");
//		cs1.setPassword("This#is#new#customer");
//		cs1.setAddress(address1);
//		cs1.setRegisterOn(LocalDate.of(2021, 2, 14));
		
//		Customer c = new Customer();
//		c.setCustomerId(6);
//		customerService.createCustomer(cs);
		customerService.createCustomer(cs);
		
//		assertEquals(1, customerRepository.count());
	}
	
//	@Test
	public void testListCustomers() {
		
		List<Customer> myList = customerRepository.findAll();
		
		System.out.println(myList);
	}
	
//	@Test
	public void testDeleteCustomer() {
		
		Customer cs = customerRepository.findByEmail("qwe@qwe.com");
		customerService.deleteCustomer(cs);
	}
	
//	@Test
	public void testViewCustomer() {
		
		Customer cs = customerRepository.findByEmail("abcdef@abc.com");
		System.out.println(customerService.viewCustomer(cs));
		
	}
	
	
//	@Test
	public void testUpdateCustomer() {
		
		Customer cs = customerRepository.findByEmail("abcdef@abc.com");
		cs.setMobileNumber("1234123412");
		
		customerService.updateCustomer(cs);
		
	}
	
//	@Test
	public void testListAllCustomersByBook() {
		
		Book book  = bookRepository.findByTitle("Harry Potter");
		System.out.println(customerService.listAllCustomersByBook(book));
	}
}
