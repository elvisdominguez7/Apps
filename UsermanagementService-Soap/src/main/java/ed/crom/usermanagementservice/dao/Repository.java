package ed.crom.usermanagementservice.dao;


import ed.crom.usermanagementservice.models.User;
import ed.crom.usermanagementservice.exceptions.UserExistFault;
import ed.crom.usermanagementservice.exceptions.UserNotFoundFault;



public interface Repository {
	
	public void save(User user) throws UserExistFault, UserNotFoundFault;
	
	public User retrieve(long id) throws UserExistFault, UserNotFoundFault;
	
	public void update(User user) throws UserExistFault, UserNotFoundFault;
	
	public void delete(long id) throws UserExistFault, UserNotFoundFault;
	

}
