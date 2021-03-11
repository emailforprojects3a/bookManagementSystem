package book.management.system.app.serviceInterface;

import java.util.List;

import book.management.system.app.entities.Book;
import book.management.system.app.entities.Customer;

public interface ICustomerService {

	public Customer createCustomer(Customer c);
	public List<Customer> listCustomers();
	public Customer deleteCustomer(Customer c);
	public Customer viewCustomer(Customer c);
	public Customer updateCustomer(Customer c);
	public List<Customer> listAllCustomersByBook(Book book);
}
