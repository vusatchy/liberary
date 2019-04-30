package com.books.liberary.repository;

import com.books.liberary.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByName(String name);

    User findByName(String name);

}