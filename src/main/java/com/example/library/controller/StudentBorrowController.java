package com.example.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.library.dto.request.BorrowRequest;
import com.example.library.dto.response.BorrowResponse;
import com.example.library.service.StudentBorrowService;

@RestController
@RequestMapping("/borrow")
@RequestScope
@CrossOrigin
public class StudentBorrowController {
	private final StudentBorrowService studentBorrowService;

	public StudentBorrowController(StudentBorrowService studentBorrowService) {
		this.studentBorrowService = studentBorrowService;
	}





	@GetMapping("getAll")
	public List<BorrowResponse> getAll() {
		return studentBorrowService.getAll();
	}

	/*@PostMapping
	public BorrowResponse addBorrow(@RequestBody BorrowRequest borrow) throws Exception {
		System.err.println("controller");
		return borrowService.addBorrow(borrow);
	}*/
}
