package com.nevalabs.repositories;

import com.nevalabs.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by serpilkuzu on 24/01/2017.
 */
public interface BookRepository extends CrudRepository<Book, Integer> {

}
