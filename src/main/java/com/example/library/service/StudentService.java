package com.example.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.library.entity.Student;
import com.example.library.repository.StudentRepository;

@Service
public class StudentService {

	StudentRepository studentRepository;

	private StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	public Student add(Student ogrenci) {
		var ogr=studentRepository.save(ogrenci);
		return ogr;
	}
	public Optional<List<Student>> getAll(){
		return Optional.of(studentRepository.findAll());
	}

}
