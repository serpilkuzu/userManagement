package com.nevalabs;

import com.nevalabs.model.User;
import com.nevalabs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class UserManagementApplication {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
		public String sayHello() {
		User user = userRepository.findOne(1);

		return "Hello Spring! " + user.getName() + " reads ";
	}

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}
}
