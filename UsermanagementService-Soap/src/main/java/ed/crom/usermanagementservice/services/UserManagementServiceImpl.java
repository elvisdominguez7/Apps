package ed.crom.usermanagementservice.services;


import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import ed.crom.usermanagementservice.models.User;
import ed.crom.usermanagementservice.models.UserId;
import ed.crom.usermanagementservice.delegate.UserManagementDelegate;
import ed.crom.usermanagementservice.exceptions.UserExistFault;
import ed.crom.usermanagementservice.exceptions.UserNotFoundFault;



@WebService(
		serviceName = "UserManagementService", 
		portName = "UserManagementServicePort",
		targetNamespace = "http://www.usermanagement.com/",
		endpointInterface = "ed.crom.usermanagementservice.services.UserManagementService")
public class UserManagementServiceImpl implements UserManagementService {
	
	@Autowired
	private UserManagementDelegate delegate;

	@Override
	public void registerUser(User user) throws UserExistFault, UserNotFoundFault {
		delegate.registerUser(user);
		
		

	}

	@Override
	public User retrieveUser(UserId id) throws UserExistFault, UserNotFoundFault {
		return delegate.retrieveUser(id);
		
	
	}

	@Override
	public void updateUser(User user) throws UserExistFault, UserNotFoundFault {
		delegate.updateUser(user);
		

	}

	@Override
	public void deleteUser(UserId id) throws UserExistFault, UserNotFoundFault {
		delegate.deleteUser(id);
		

	}


}
