package com.cni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cni.model.User;
import com.cni.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserModelController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/findAll")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}
	

	@PostMapping("/save")
	public User findAllUsers(@RequestBody User user) {
		return userService.save(user);
	}
}
