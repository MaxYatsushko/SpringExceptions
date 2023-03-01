package com.example.springexceptions.service;

import com.example.springexceptions.exception.WrongLoginException;
import com.example.springexceptions.exception.WrongPasswordException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserService {
    public static boolean checkData(String user, String password, String confirmPassword) {
        String pattern = "\\w+";

        if (user.length() < 1 || user.length() > 20)
            throw new WrongLoginException("Incorrect length of login. You should input 1-20 symbols");

        boolean correctLogin = Pattern.matches(pattern, user);
        if (!correctLogin)
            throw new WrongLoginException("Incorrect symbols in login. You should input letter symbols, numbers or \"_\"");

        if(password.length() < 1 || password.length() > 19)
            throw new WrongPasswordException("Incorrect length of password. You should input 1-20 symbols");

        boolean correctPassword = Pattern.matches(pattern, password);
        if (!correctPassword)
            throw new WrongPasswordException("Incorrect symbols in password. You should input letter symbols, numbers or \"_\"");

        if(!password.equals(confirmPassword))
            throw new WrongPasswordException("Confirm password and password are different");

        return true;
    }
}
