package book.management.system.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.management.system.app.entities.User;
import book.management.system.app.exception.PasswordMisMatchException;
import book.management.system.app.exception.UserAlreadyExistException;
import book.management.system.app.exception.UserNotFoundException;
import book.management.system.app.repos.ILoginRepository;
import book.management.system.app.serviceInterface.ILoginService;

@Service
public class LoginService implements ILoginService {
	
	@Autowired
	ILoginRepository loginRepository;

	@Override
	public User addUser(User user) {

		User userObj = loginRepository.findByEmail(user.getEmail());
		
		if(userObj == null) {
		
			loginRepository.save(user);
			
		}
		
		else
			throw new UserAlreadyExistException("User with the email " + user.getEmail() + " already exist");
		
		return user;
	}

	@Override
	public User removeUser(User user) {
		
		User userObj = loginRepository.findByEmail(user.getEmail());
		
		if(userObj == null) 
			throw new UserNotFoundException("User with the email " + user.getEmail() + " not found");
		
		else
			loginRepository.delete(userObj);
			
		return userObj;
	}

	@Override
	public User validateUser(User user) {
		
		User userObj = loginRepository.findByEmail(user.getEmail());
		
		if(userObj == null) 
			throw new UserNotFoundException("User with the email " + user.getEmail() + " not found");
		
		else {
			
			if(userObj.getPassword().equals(user.getPassword()))
				return userObj;
			else
				throw new PasswordMisMatchException("Password is wrong");
		}
		

	}

}
