package com.sleepy.RestServices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sleepy.RestServices.services.UserService;
import com.sleepy.RestServices.entities.User;
import com.sleepy.RestServices.exceptions.userExistsException;
import com.sleepy.RestServices.exceptions.userNotFoundException;

import java.util.*;

import javax.validation.Valid;

@RestController
public class userController {
 
	@Autowired
	public UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUser(){
		return userService.getAllUsers();
		
	}
	
	@PostMapping("/addUser")
	public User createUser(@Valid @RequestBody  User u) {
		try {
			return userService.createUser(u);
		} catch (userExistsException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable ("id") long id) {
		try {
			return userService.getUserById(id);
		} catch (userNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
	
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable ("id") long id, @RequestBody  User user) {
		try {
			return userService.updateUserById(id, user);
		} catch (userNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable ("id") long id) {
		try {
			userService.deleteUserById(id);
		} catch (userNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
	@GetMapping("/usersByName/{name}")
	public User getByName(@PathVariable("name") String name) {
		return userService.getByName(name);
	}
}
