package com.example.smartcontactmanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smartcontactmanager.entity.User;
import com.example.smartcontactmanager.repository.UserRepository;

@Service
public class UserService {
	 @Autowired
	    private UserRepository userRepository;
	    public User saveUser(User user) {
	        return userRepository.save(user);
	    }
	    public Optional<User> findByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }
}
