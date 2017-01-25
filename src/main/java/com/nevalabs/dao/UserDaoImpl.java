package com.nevalabs.dao;

import com.nevalabs.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serpilkuzu on 24/01/2017.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> getAllUsers() {
        // TODO serpil
        List<User> users = new ArrayList<User>();
        return users;
    }

    @Override
    public User getUser() {
        // TODO serpil
        User user = new User();
        user.setId(4);
        user.setName("serpilkuzu");
        user.setSurname("kzuu");
        user.setAge(23);
        user.setGender(0);
        return user;
    }

    @Override
    public void createUser(User user) {
        // TODO serpil
    }

}
