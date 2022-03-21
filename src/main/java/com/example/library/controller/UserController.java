package com.example.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.library.entity.User;
import com.example.library.service.UserService;
import com.example.library.service.UserServiceImp;

@RestController
@RequestMapping("/user")
@RequestScope
@CrossOrigin
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/getall")
	public List<User> getAll(){
	    return userService.findAll();	
	}
	@PostMapping("/adduser")
	public Optional<User> addUser(@RequestBody User user) {
		return userService.add(user);
	}
	
	
}
