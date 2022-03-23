package com.example.library.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.library.dto.request.StudentAddRequest;
import com.example.library.dto.response.StudentResponse;
import com.example.library.entity.Student;
import com.example.library.repository.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
	
	public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
		this.studentRepository = studentRepository;
		this.modelMapper = modelMapper;
	}
	
	public StudentResponse add(StudentAddRequest request) {
		var ogrenci = modelMapper.map(request, Student.class);
		
		var addedStudent = studentRepository.save(ogrenci);
		
		return modelMapper.map(addedStudent, StudentResponse.class);
	}
	
	public Optional<List<Student>> getAll(){
		return Optional.of(studentRepository.findAll());
	}

}
