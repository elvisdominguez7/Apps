package ed.crom.usermanagementservice.delegate;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ed.crom.usermanagementservice.dao.*;
import ed.crom.usermanagementservice.exceptions.UserExistFault;
import ed.crom.usermanagementservice.exceptions.UserNotFoundFault;
import ed.crom.usermanagementservice.models.User;
import ed.crom.usermanagementservice.models.UserId;


@Component
public class UserManagementDelegate{
	
	private final static Logger logger = Logger.getLogger(UserManagementDelegate.class);

	
	@Autowired
	private InMemoryRepository repo;

	
	public void updateUser(User user) throws UserExistFault, UserNotFoundFault {
		try {
			repo.update(user);
		} catch (UserExistFault | UserNotFoundFault e) {
			logger.info("Wrong Input/No User Found", e);
			throw e;

		}
		
		
	}

	
	public void registerUser(User user) throws UserExistFault, UserNotFoundFault {
		try {
			repo.save(user);
		} catch (UserExistFault | UserNotFoundFault e) {
			logger.info("Wrong Input/No User Found", e);
			throw e;

		}
		
	}

	
	public void deleteUser(UserId id) throws UserExistFault, UserNotFoundFault {
		try {
			repo.delete(id.getUserID());
		} catch (UserExistFault | UserNotFoundFault e) {
			logger.info("Wrong Input/No User Found", e);
			throw e;

		}
		
	}

	
	public User retrieveUser(UserId id) throws UserExistFault, UserNotFoundFault {
	User userFound;
		
		try {
			 userFound = repo.retrieve(id.getUserID());
		} catch (UserExistFault | UserNotFoundFault e) {
			logger.info("Wrong Input/No User Found", e);
			throw e;

		}
		return userFound;
	}

}
