package com.nevalabs;

import com.nevalabs.model.User;
import com.nevalabs.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

	@Autowired
	UserService userService;

	private final Logger logger = LoggerFactory.getLogger(UserServiceTests.class);

	private static int userId;
	private static String name = "test name";
	private static String surname = "test surname";
	private static int age = 20;
	private static String email = "serpil.kuzu@nevalabs.com";

	@Before
	public void createUser_BeforeTest_Created() {
		User testUser = new User();
		testUser.setName(name);
		testUser.setSurname(surname);
		testUser.setAge(age);
		testUser.setEmail(email);
		userId = userService.save(testUser);
		logger.info("User with id " + userId + " is created.");
	}

	@Test
	public void findUser_GivenNameAndSurname_Found(){
		List<User> userList = userService.searchByNameAndSurname(name.substring(3, name.length()-2), surname.substring(2));
		assert userList.stream().filter(user -> user.getId() == userId).findAny().isPresent();
		logger.info("Created user with id " + userId + " is found in database by search query.");
	}

	@Test
	public void checkUserInformation_KnownParameters_Matched() {
		User user = userService.findOne(userId);
		assert user.getName().equals(name);
		assert user.getSurname().equals(surname);
		assert user.getAge() == age;
		assert user.getEmail().equals(email);
		logger.info("User information with id " + userId + " is the same as data in database.");
	}

	// This method deletes users which are created for test purposes
	@After
	public void deleteUser_AfterTest_Deleted() {
		userService.delete(userId);
		logger.info("User with id " + userId + " is deleted.");
	}
}
