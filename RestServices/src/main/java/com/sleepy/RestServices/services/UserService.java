package com.sleepy.RestServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sleepy.RestServices.Repositories.userRepository;
import com.sleepy.RestServices.entities.User;
import com.sleepy.RestServices.exceptions.userExistsException;
import com.sleepy.RestServices.exceptions.userNotFoundException;

import java.util.*;

@Service
public class UserService {
	@Autowired
	public userRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User createUser(User u) throws userExistsException {
		long id=u.getId();
		if(!userRepository.findById(id).isPresent()) {
			return userRepository.save(u);
		}else {
			throw new userExistsException("user Already in the repository");
		}
		
		
	}
	public Optional<User> getUserById(long id) throws userNotFoundException {
		Optional<User> user= userRepository.findById(id);
		System.out.print("user not found"+ user);
		if(!user.isPresent()) {
			System.out.print("user not found");
			throw new userNotFoundException("user is Not Found in thr repository");
		}
		return user;
	}
	public User updateUserById(long id,User user) throws userNotFoundException {
		Optional<User> userOp= userRepository.findById(id);
		//System.out.print("user not found"+ user);
		if(!userOp.isPresent()) {
			//System.out.print("user not found");
			throw new userNotFoundException("user is Not Found in thr repository, Please give the correct userId to update");
		}
		user.setId(id);
		return userRepository.save(user);
	}
	public void deleteUserById(long id) throws userNotFoundException {
		if(userRepository.existsById(id)) {
		  userRepository.deleteById(id);
		}else {
			throw new userNotFoundException("user is Not Found in thr repository, Please give the correct userId to delete");
		}
	}
	public User getByName(String name) {
		return userRepository.findByName(name);
	}

}
