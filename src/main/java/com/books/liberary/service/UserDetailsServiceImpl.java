package com.books.liberary.service;


import com.books.authication.AuthenticationChain;
import com.books.authication.NameExistAuthentication;
import com.books.authication.ValidEmailAuthentication;
import com.books.authication.ValidPasswordAuthentication;
import com.books.liberary.exception.InvalidEmailException;
import com.books.liberary.exception.InvalidPasswordException;
import com.books.liberary.exception.UserAlreadyExistException;
import com.books.liberary.model.Role;
import com.books.liberary.model.User;
import com.books.liberary.repository.UserRepository;
import com.books.liberary.security.UserPrincipalImpl;
import com.books.liberary.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipalImpl(user);
    }

    @Override
    public User saveUser(String name, String email, String password)
        throws InvalidPasswordException, UserAlreadyExistException, InvalidEmailException {
        User user = new User();
        user.setName(name);
        user.setMail(email);
        user.setPassword(password);
        user.setRole(Role.USER);
        AuthenticationChain authenticationChain = new NameExistAuthentication(userRepository);
        authenticationChain.linkWith(new ValidEmailAuthentication())
                           .linkWith(new ValidPasswordAuthentication());
        authenticationChain.check(user);
        user.setPassword(EncryptionUtil.encrypt(user.getPassword()));
        return userRepository.save(user);
    }
}