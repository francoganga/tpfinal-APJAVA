package com.unaj.edu.services;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;


import com.unaj.edu.models.User;
import com.unaj.edu.repository.UserRepository;

import java.util.HashSet;

import com.unaj.edu.web.PasswordEncoder;

@Service
public class UserService{
	@Autowired
    private UserRepository userRepository;

    
    public void save(User user) {

    	String salt = PasswordEncoder.getSalt(30);

    	String securePassword = PasswordEncoder.generateSecurePassword(user.getPassword(), salt);

    	user.setPassword(securePassword);
    	user.setSalt(salt);
        user.setPoints(10);
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

