package com.nevalabs.controller;

import com.nevalabs.model.User;
import com.nevalabs.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by serpilkuzu on 24/01/2017.
 */
@CrossOrigin
@RestController
@RequestMapping(value = "users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        return userService.findOne(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = "application/json")
    public User editUser(@RequestBody User user) {
        return userService.save(user);

    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable int id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> getAllUsers() {
        return userService.findAll();
    }

}