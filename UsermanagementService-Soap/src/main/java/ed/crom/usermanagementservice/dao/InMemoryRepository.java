package ed.crom.usermanagementservice.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import ed.crom.usermanagementservice.models.User;
import ed.crom.usermanagementservice.exceptions.UserExistFault;
import ed.crom.usermanagementservice.exceptions.UserNotFoundFault;


@Component
public class InMemoryRepository implements Repository {
	
	private Map<Long,User> users = new HashMap<Long, User>();

	@Override
	public void save(User user) throws UserExistFault, UserNotFoundFault{
		users.put(user.getUserID(), user);
		
	}

	@Override
	public User retrieve(long id) throws  UserExistFault, UserNotFoundFault{
		if( id == 0){
			throw new UserExistFault("Invalid input");		}
		if(!users.containsKey(id)){
			throw new UserNotFoundFault("User does not Exists");
		}
		
		return users.get(id);
	}


	@Override
	public void update(User user) throws  UserExistFault, UserNotFoundFault{
		if( user == null){
			throw new UserExistFault("Invalid input");		}
		if(!users.containsKey(user.getUserID())){
			throw new UserNotFoundFault("User does not Exists");
		}
		
			users.put(user.getUserID(), user);		
	}
		

	@Override
	public void delete(long id) throws  UserExistFault, UserNotFoundFault{
		if( id == 0){
			throw new UserExistFault("Invalid input");		}
		if(!users.containsKey(id)){
			throw new UserNotFoundFault("User does not Exists");
		}
		users.remove(id);
		
	}
	


}
