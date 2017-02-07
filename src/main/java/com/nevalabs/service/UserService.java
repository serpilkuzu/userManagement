package com.nevalabs.service;

import com.nevalabs.model.User;

import java.util.List;

/**
 * Created by serpilkuzu on 24/01/2017.
 */
public interface UserService {

    List<User> searchByNameAndSurname(String name, String surname);

    User findOne(int id);

    void update(int id, User user);

    int save(User user);

    void delete(int id);

    Iterable<User> findAll();

}
