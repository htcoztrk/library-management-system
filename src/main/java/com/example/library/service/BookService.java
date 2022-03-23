package com.example.library.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.library.repository.BookRepository;

@Service
public class BookService{

	private BookRepository bookRepository;
	private ModelMapper modelMapper;
	
	public BookService(BookRepository bookRepository, ModelMapper modelMapper) {
		this.bookRepository = bookRepository;
		this.modelMapper = modelMapper;
	}

	
	
}
