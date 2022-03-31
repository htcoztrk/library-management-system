package com.example.library.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.library.dto.request.StudentReservationRequest;
import com.example.library.dto.response.StudentReservationResponse;
import com.example.library.entity.Book;
import com.example.library.entity.Student;
import com.example.library.repository.StudentReservationRepository;
import com.example.library.utilities.rules.RuleResult;

@Service
public class StudentReservationService {

	private StudentReservationRepository reservationRepository;
	private ModelMapper modelMapper;
	private BookService bookService;
	private StudentService studentService;

	public StudentReservationService(StudentReservationRepository reservationRepository, ModelMapper modelMapper,
			BookService bookService, StudentService studentService) {
		this.reservationRepository = reservationRepository;
		this.modelMapper = modelMapper;
		this.bookService = bookService;
		this.studentService = studentService;
	}
	/*@Transactional
	public StudentReservationResponse addStudentReservation(StudentReservationRequest request) {
		var student=modelMapper.map(studentService.findById(request.getStudent().getId()), Student.class);
		var book=modelMapper.map(bookService.getById(request.getBook().getId()),Book.class );
		
		
	}*/

}
