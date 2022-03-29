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
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	

	

}
