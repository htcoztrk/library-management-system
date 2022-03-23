package com.example.library.service;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.User;

public interface UserService {

	Optional<User> add(User user);
	Optional<User> update(User user);
	Optional<User> findById(int id);
	List<User> findAll();
}
