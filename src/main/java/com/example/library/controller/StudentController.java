package com.example.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.entity.Student;
import com.example.library.entity.User;
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
	@PostMapping("/adduser")
	public User addUser(@RequestBody Student ogrenci) {
		return studentService.add(ogrenci);
	}
}
