package com.example.library.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.library.dto.request.BorrowRequest;
import com.example.library.dto.response.BorrowResponse;
import com.example.library.repository.StudentBorrowRepository;

@Service
public class StudentBorrowService {

	private final StudentBorrowRepository borrowRepository;
    private final BookService bookService;
	private final ModelMapper modelMapper;

	

	public StudentBorrowService(StudentBorrowRepository borrowRepository, BookService bookService,
			ModelMapper modelMapper) {
		this.borrowRepository = borrowRepository;
		this.bookService = bookService;
		this.modelMapper = modelMapper;
	}



	public List<BorrowResponse> getAll() {
		return borrowRepository.findAll()
				.stream()
				.map(borrow->modelMapper.map(borrow, BorrowResponse.class))
				.toList();
	}
}
