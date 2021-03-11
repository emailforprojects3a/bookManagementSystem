package book.management.system.app.serviceInterface;

import java.util.List;

import book.management.system.app.entities.Book;
import book.management.system.app.entities.Customer;
import book.management.system.app.entities.OrderDetails;

public interface IOrderService {

	public List<OrderDetails> listAllOrders();
	public List<OrderDetails> listOrderByCustomer(Customer cs);
	public OrderDetails viewOrderForCustomer(OrderDetails od);
	public OrderDetails viewOrderForAdmin(OrderDetails od);
	public OrderDetails cancelOrder(OrderDetails od);
	public OrderDetails addOrder(OrderDetails od);
	public OrderDetails updateOrder(OrderDetails od);
	public List<OrderDetails> viewOrderByBook(Book book);
	
	
}
