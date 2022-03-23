package com.example.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.library.entity.User;
import com.example.library.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

	private UserRepository userRepository;
  
	private UserServiceImp(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Optional add(User user) {
		var savedUser=userRepository.save(user);
		return Optional.of(savedUser);
	}

	@Override
	public Optional update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	

}
