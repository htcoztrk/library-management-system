package com.example.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.library.dto.request.StudentBorrowRequest;
import com.example.library.dto.response.StudentBorrowResponse;
import com.example.library.service.StudentBorrowService;

@RestController
@RequestMapping("/studentborrow")
@RequestScope
@CrossOrigin
public class StudentBorrowController {
	
	private final StudentBorrowService studentBorrowService;

	public StudentBorrowController(StudentBorrowService studentBorrowService) {
		this.studentBorrowService = studentBorrowService;
	}

    @GetMapping("getAll")
	public List<StudentBorrowResponse> getAll() {
		return studentBorrowService.getAll();
	}

	@PostMapping
	public StudentBorrowResponse addBorrow(@RequestBody StudentBorrowRequest borrow) throws Exception {
		return studentBorrowService.addStudentBorrow(borrow);
	}
}
