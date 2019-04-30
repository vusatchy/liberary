package com.books.authication;


import com.books.liberary.exception.InvalidEmailException;
import com.books.liberary.exception.InvalidPasswordException;
import com.books.liberary.exception.UserAlreadyExistException;
import com.books.liberary.model.User;
import com.books.liberary.repository.UserRepository;

import java.text.MessageFormat;

public class NameExistAuthentication extends AuthenticationChain {

    private UserRepository userRepository;

    public NameExistAuthentication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void check(User user) throws UserAlreadyExistException, InvalidEmailException, InvalidPasswordException {
	if (userRepository.existsByName(user.getName())) {
	    throw new UserAlreadyExistException(MessageFormat.format("User with name {0} already exit",
		user.getName()));
	}
	checkNext(user);
    }
}