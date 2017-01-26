package com.nevalabs.repositories;

import com.nevalabs.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * Created by serpilkuzu on 24/01/2017.
 */
public interface UserRepository extends CrudRepository<User, Integer>{

    @Query("SELECT user from User user WHERE " +
            "LOWER(user.name) LIKE CONCAT('%',:username, '%') AND " +
            "LOWER(user.surname) LIKE CONCAT('%',:userSurname, '%')")
    List<User> searchByNameAndSurname(@Param("username") String username, @Param("userSurname") String surname);

}
