package bookstore.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import bookstore.bookstore.domain.User;
import bookstore.bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
    private UserRepository urepository;

    //Search
    @Test
    public void findByRole() {
        List<User> user = urepository.findByRole("ADMIN");
        
        assertThat(user).hasSize(1);
    }
    
    //Add
    @Test
    public void addNewUser() {
    	User user = new User("testUser", "testPassword", "testEmail", "testRole");
    	urepository.save(user);
    	assertThat(user.getId()).isNotNull();
    }  
    
    //Delete
    @Test
    public void deleteRole() {
    	// add new testuser
    	User testuser = new User("testUser", "testPassword", "testEmail", "testRole");
    	urepository.save(testuser);
    	assertThat(testuser.getId()).isNotNull();
    	
    	//find added testuser
    	List<User> user = urepository.findByRole("testRole");
    	assertThat(user).hasSize(1);
        
    	//remove found testuser
    	urepository.delete(user);
    }
}
