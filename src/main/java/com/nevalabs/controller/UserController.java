package com.nevalabs.controller;

import com.nevalabs.model.User;
import com.nevalabs.repositories.UserRepository;
import com.nevalabs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by serpilkuzu on 24/01/2017.
 */
@RestController
public class UserController {


    @Autowired
    UserRepository userRepository;


    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public String sayHello() {
        User user = userRepository.findOne(1);

        return "Hello Spring! " + user.getName() + " reads ";
    }

    @RequestMapping(value = "get")
    public String getUser() {
        return "Hi";
    }


}
