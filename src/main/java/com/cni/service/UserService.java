package com.cni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.model.User;
import com.cni.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAllUsers() {
		List<User> users  = userRepository.findAll();
		
		return users;
	}
	
	public User save(User user) {
		User userSaved = userRepository.save(user);
		return userSaved;
	}
}
