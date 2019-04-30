package com.books.liberary.service;

import com.books.liberary.exception.*;
import com.books.liberary.model.User;

public interface UserService {

    User saveUser(String name, String email, String password)
        throws InvalidPasswordException, UserAlreadyExistException, InvalidEmailException;
}