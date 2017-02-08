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
    public ResponseEntity editUser(@PathVariable int id, @RequestBody User user) {
        try {
            userService.findOne(id).getId();
            userService.update(id, user);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.toString() + " :: User id " + id + " is not found in database!");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity createUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity(HttpStatus.OK);
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