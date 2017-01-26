package com.nevalabs.dao;

import com.nevalabs.model.User;

import java.util.List;

/**
 * Created by serpilkuzu on 24/01/2017.
 */
public interface UserDao {

    public List<User> getAllUsers();

    public List<User> filterUser(User user);

    public void createUser(User user);

}
