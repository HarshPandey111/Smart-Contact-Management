package com.example.smartcontactmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartcontactmanager.entity.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
	 @PostMapping
	    public ResponseEntity<User> createUser(@RequestBody User user) {
	        User savedUser = userService.saveUser(user);
	        return ResponseEntity.ok(savedUser);
	    }
	 @GetMapping("/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Long id) {
	        return userService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
	  @GetMapping("/email/{email}")
	    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
	        return userService.findByEmail(email)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
}
