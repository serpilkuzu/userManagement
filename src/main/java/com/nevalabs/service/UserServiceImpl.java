package com.nevalabs.service;

import com.nevalabs.model.User;
import com.nevalabs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by serpilkuzu on 24/01/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> searchByNameAndSurname(String name, String surname) {
        String queryName = (name != null) ? name.toLowerCase() : "";
        String querySurname = (surname != null) ? surname.toLowerCase() : "";
        List<User> userList = userRepository.findContainingNameAndSurname(queryName, querySurname);
        return userList;
    }
}

