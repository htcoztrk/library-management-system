package com.example.library.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.library.dto.request.StudentBorrowRequest;
import com.example.library.dto.response.StudentBorrowResponse;
import com.example.library.entity.BookType;
import com.example.library.entity.StudentBorrow;
import com.example.library.repository.StudentBorrowRepository;

@Service
public class StudentBorrowService {

	private final StudentBorrowRepository studentBorrowRepository;
    private final BookService bookService;
	private final ModelMapper modelMapper;
	private final StudentService studentService;

	

	public StudentBorrowService(StudentBorrowRepository studentBorrowRepository, BookService bookService,
			ModelMapper modelMapper,StudentService studentService) {
		this.studentBorrowRepository = studentBorrowRepository;
		this.bookService = bookService;
		this.modelMapper = modelMapper;
		this.studentService=studentService;
	}

	public StudentBorrowResponse addStudentBorrow(StudentBorrowRequest request) throws Exception {
		if(!request.getBook().getBookType().equals(BookType.NORMAL)) {
			throw new Exception("Only normal book can be borrowed");
		}
		
		if(studentService.findById(request.getStudent().getId())==null) {
			throw new Exception("there is no student");
		}
		var borrow=modelMapper.map(request, StudentBorrow.class);
		return modelMapper.map(studentBorrowRepository.save(borrow),StudentBorrowResponse.class);
	}
	public StudentBorrowResponse getById(Long id) {
		var studentBorrow=studentBorrowRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
		return modelMapper.map(studentBorrow, StudentBorrowResponse.class);
		
	}

	public List<StudentBorrowResponse> getAll() {
		return studentBorrowRepository.findAll()
				.stream()
				.map(borrow->modelMapper.map(borrow, StudentBorrowResponse.class))
				.toList();
	}
}
