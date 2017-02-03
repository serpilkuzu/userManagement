package com.nevalabs;

import com.nevalabs.model.User;
import com.nevalabs.repositories.UserRepository;
import com.nevalabs.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagementApplicationTests {

    @Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	private static int userId;
	private static String name = "test name";
	private static String surname = "test surname";

	@Before
	public void setUpOnce() {
        User testUser = new User();
        testUser.setName(name);
        testUser.setSurname(surname);
        userId = userRepository.save(testUser).getId();
    }

	@Test
	public void testSearchByNameAndSurname(){
		List<User> userList = userService.searchByNameAndSurname(name.substring(3, name.length()-2), surname.substring(2));
        assert userList.stream().filter(user -> user.getId() == userId).findAny().isPresent();
	}

	@Test
    public void testCreateUser() {
	    User user = userRepository.findOne(userId);
	    assert user.getName().equals(name);
    }

    @After
    public void deleteUser() {
	    userRepository.delete(userId);
    }

}
