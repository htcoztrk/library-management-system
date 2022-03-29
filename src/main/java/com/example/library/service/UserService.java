package com.example.library.service;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.User;

public interface UserService {

	User findById(Long id);
	List<User> findAll();
}
