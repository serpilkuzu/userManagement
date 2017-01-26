package com.nevalabs.service;

import com.nevalabs.model.User;

import java.util.List;

/**
 * Created by serpilkuzu on 24/01/2017.
 */
public interface UserService {

    List<User> searchByNameAndSurname(String name, String surname);

}
