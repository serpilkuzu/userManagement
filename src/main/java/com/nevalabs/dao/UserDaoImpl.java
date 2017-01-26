package com.nevalabs.dao;

import com.nevalabs.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serpilkuzu on 24/01/2017.
 */
@Transactional
@Repository("UserRepository")
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        // TODO serpil
        List<User> users = new ArrayList<User>();
        return users;
    }

    @Override
    public List<User> filterUser(User user) {
        Query query = entityManager.createQuery("select user from "+ User.class.getName() + " user where user.name LIKE CONCAT('%', :name , '%') AND user.surname LIKE CONCAT('%', :surname , '%')");
        if (user.getName() != null) {
            query.setParameter("name", user.getName());
        } else {
            query.setParameter("name", "");
        }
        if (user.getSurname() != null) {
            query.setParameter("surname", user.getSurname());
        } else {
            query.setParameter("surname", "");
        }
        return query.getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

}
