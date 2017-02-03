package com.nevalabs.repositories;

import com.nevalabs.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * Created by serpilkuzu on 24/01/2017.
 */
public interface UserRepository extends CrudRepository<User, Integer>{

    @Query("SELECT user from User user WHERE " +
            "LOWER(user.name) LIKE %?1% AND " +
            "LOWER(user.surname) LIKE %?2%)")
    List<User> findContainingNameAndSurname(String username, String surname);

    List<User> findByNameAndSurnameAllIgnoreCase(String name, String surname, Sort sort);

    Iterable<User> findAll(Sort sort);

}
