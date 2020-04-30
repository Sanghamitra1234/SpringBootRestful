package com.sleepy.RestServices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sleepy.RestServices.services.UserService;
import com.sleepy.RestServices.entities.User;
import java.util.*;

@RestController
public class userController {
 
	@Autowired
	public UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUser(){
		return userService.getAllUsers();
		
	}
	
	@PostMapping("/addUser")
	public User createUser(@RequestBody  User u) {
		return userService.createUser(u);
		
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable ("id") long id) {
		return userService.getUserById(id);
	}
	
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable ("id") long id, @RequestBody  User user) {
		return userService.updateUserById(id, user);
	}
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable ("id") long id) {
		userService.deleteUserById(id);
	}
	@GetMapping("/usersByName/{name}")
	public User getByName(@PathVariable("name") String name) {
		return userService.getByName(name);
	}
}
