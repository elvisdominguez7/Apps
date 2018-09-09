/*package ed.crom.usermanagementservice.repository;

import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;

import ed.crom.usermanagementservice.repository.UserRepository;
import ed.crom.usermanagementservice.exceptions.NoUserFoundFault;
import ed.crom.usermanagementservice.exceptions.NoUserInputFault;
import ed.crom.usermanagementservice.models.User;

public class UserRepositoryTest {
	
	UserRepository repo = null;
	User user = null;

	@Before
	public void setUp() throws Exception {
		repo = new UserRepository();
		user = new User();
		
		user.setId(1L);
		user.setFirstName("test");
		user.setLastName("testing");
		
		this.saveUserHelper(user);
		
	}

	@Test
	public void testSave() throws NoUserInputFault, NoUserFoundFault {
		Assert.assertEquals(repo.retrieve(1L),user);
		
	}

	@Test
	public void testRetrieve() throws NoUserInputFault, NoUserFoundFault {
		Assert.assertEquals(repo.retrieve(1L), user);
	}

	@Test
	public void testUpdate() throws NoUserInputFault, NoUserFoundFault {	
		user.setFirstName("Updated");
		user.setLastName("updated");
		
		repo.update(user);
		Assert.assertEquals(repo.retrieve(1L),user);
		
	}

	@Test(expected = NoUserFoundFault.class)
	public void testDelete() throws NoUserInputFault, NoUserFoundFault {
		repo.delete(1L);
		
	}
	
	public void saveUserHelper(User user) throws NoUserInputFault, NoUserFoundFault{
		repo.save(user);
		
	}

}
*/