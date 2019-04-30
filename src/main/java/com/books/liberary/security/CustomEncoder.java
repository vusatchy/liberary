package com.books.liberary.security;

import com.books.liberary.util.EncryptionUtil;
import org.springframework.security.crypto.password.PasswordEncoder;


public class CustomEncoder implements PasswordEncoder {


    @Override
    public String encode(CharSequence rawPassword) {
        return EncryptionUtil.encrypt(String.valueOf(rawPassword));
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return EncryptionUtil.encrypt(String.valueOf(rawPassword)).equals(encodedPassword);
    }
}