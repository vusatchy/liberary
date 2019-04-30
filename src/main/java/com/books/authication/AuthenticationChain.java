package com.books.authication;


import com.books.liberary.exception.InvalidEmailException;
import com.books.liberary.exception.InvalidPasswordException;
import com.books.liberary.exception.UserAlreadyExistException;
import com.books.liberary.model.User;

public abstract class AuthenticationChain {

    private AuthenticationChain next;

    public AuthenticationChain linkWith(AuthenticationChain next) {
        this.next = next;
	return next;
    }

    public abstract void check(User user) throws UserAlreadyExistException, InvalidEmailException,
                                                 InvalidPasswordException;

    protected void checkNext(User user) throws UserAlreadyExistException,InvalidEmailException,InvalidPasswordException {
	if (next == null) {
	    return;
	}
	next.check(user);
    }

}