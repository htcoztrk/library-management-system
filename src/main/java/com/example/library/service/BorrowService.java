package com.example.library.service;

import org.springframework.stereotype.Service;

import com.example.library.repository.BorrowRepository;

@Service
public class BorrowService {

	private final BorrowRepository borrowRepository;

	public BorrowService(BorrowRepository borrowRepository) {
		this.borrowRepository = borrowRepository;
	}


	
}
