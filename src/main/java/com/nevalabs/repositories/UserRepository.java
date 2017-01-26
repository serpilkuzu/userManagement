package com.nevalabs.repositories;

import com.nevalabs.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by serpilkuzu on 24/01/2017.
 */
public interface UserRepository extends CrudRepository<User, Integer>{

    // @Query(value = "Select a.id from user a where a.firstNa  :username", nativeQuery = true)
    List<User> findBySurname(String username);

}
