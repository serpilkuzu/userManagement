package com.nevalabs.controller;

import com.nevalabs.model.User;
import com.nevalabs.repositories.UserRepository;
import com.nevalabs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by serpilkuzu on 24/01/2017.
 */
@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity editUser(HttpServletRequest request, @RequestBody User user) throws Exception {
        try {
            userRepository.findOne(user.getId());
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity createUser(HttpServletRequest request, @RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(HttpServletRequest request, @PathVariable int id) {
        userRepository.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> getAllUsers() {
        return userRepository.findAll(new Sort("id"));
    }

    @RequestMapping(value = "filterUsers", method = RequestMethod.GET)
    public List<User> filterUsers(HttpServletRequest request) {
        return userRepository.findByNameAndSurnameAllIgnoreCase(request.getHeader("name"), request.getHeader("surname"), new Sort("id"));
    }

}