package com.example.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.dto.request.StudentAddRequest;
import com.example.library.dto.response.StudentResponse;
import com.example.library.entity.Student;
import com.example.library.service.StudentService;

@RestController
@RequestMapping("/ogrenci")
public class StudentController {
    private StudentService studentService;

	public StudentController(StudentService studentService) {
		
		this.studentService = studentService;
	}
	@GetMapping("/getall")
	public Optional<List<Student>> getAll(){
	    return studentService.getAll();	
	}
	
	@PostMapping("/addStudent")
	public StudentResponse addStudent(@RequestBody @Validated StudentAddRequest request) {
		return studentService.add(request);
	}
	
}
