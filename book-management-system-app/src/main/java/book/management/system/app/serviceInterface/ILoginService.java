package book.management.system.app.serviceInterface;

import book.management.system.app.entities.User;

public interface ILoginService {

	public User addUser(User user);
	public User removeUser(User user);
	public User validateUser(User user);
	
}
