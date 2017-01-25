package com.nevalabs.service;

import com.nevalabs.dao.UserDao;
import com.nevalabs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by serpilkuzu on 24/01/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User findUser() {
        return userDao.getUser();
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }
}
