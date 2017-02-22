package com.nevalabs.service;

import com.nevalabs.model.User;
import com.nevalabs.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by serpilkuzu on 24/01/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> searchByNameAndSurname(String name, String surname) {
        String queryName = (name != null) ? name.toLowerCase() : "";
        String querySurname = (surname != null) ? surname.toLowerCase() : "";
        List<User> userList = userRepository.findContainingNameAndSurname(queryName, querySurname);
        return userList;
    }

    @Override
    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAllByOrderByIdAsc();
    }

}

