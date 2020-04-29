package com.sleepy.RestServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sleepy.RestServices.Repositories.userRepository;
import com.sleepy.RestServices.entities.User;
import java.util.*;

@Service
public class UserService {
	@Autowired
	public userRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User createUser(User u) {
		return userRepository.save(u);
		
	}
	public Optional<User> getUserById(long id) {
		return userRepository.findById(id);
	}
	public User updateUserById(long id,User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	public void deleteUserById(long id) {
		if(userRepository.existsById(id)) {
		  userRepository.deleteById(id);
		}
	}

}
