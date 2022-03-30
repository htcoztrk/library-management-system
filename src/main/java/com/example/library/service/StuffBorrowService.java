package com.example.library.service;

import org.springframework.stereotype.Service;

import com.example.library.repository.StuffRepository;

@Service
public class StuffBorrowService {

	private final StuffRepository stuffRepository;

	public StuffBorrowService(StuffRepository stuffRepository) {
		this.stuffRepository = stuffRepository;
	}
	
}
