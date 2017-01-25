package com.nevalabs.dao;

import com.nevalabs.model.User;

import java.util.List;

/**
 * Created by serpilkuzu on 24/01/2017.
 */
public interface UserDao {

    public List<User> getAllUsers();

    public User getUser();

    public void createUser(User user);

}
