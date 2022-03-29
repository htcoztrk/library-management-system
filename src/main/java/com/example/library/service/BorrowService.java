package com.example.library.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.library.dto.response.BorrowResponse;
import com.example.library.entity.BookType;
import com.example.library.entity.Borrow;
import com.example.library.repository.BorrowRepository;

@Service
public class BorrowService {

	private final BorrowRepository borrowRepository;
    private final UserService userService;
    private final BookService bookService;
	private final ModelMapper modelMapper;

	public BorrowService(BorrowRepository borrowRepository, UserService userService, BookService bookService,ModelMapper modelMapper) {
		this.borrowRepository = borrowRepository;
		this.userService = userService;
		this.bookService = bookService;
		this.modelMapper=modelMapper;
	}


	public BorrowResponse addBorrow(Borrow borrow) throws Exception {
		System.err.println("baslangic");
		var user=userService.findById(borrow.getUser().getUserId());
		System.err.println(user.getName());
		var book=bookService.getById(borrow.getBook().getId());
		if(user.getUsertype().equals("Student")) {
			if(book.getBookType().equals(BookType.LECTURE)) {
				throw new Exception("book type");
			}
			throw new Exception("student ");
		}
		borrowRepository.save(borrow);
		return modelMapper.map(borrow, BorrowResponse.class);
	}
	public List<BorrowResponse> getAll() {
		return borrowRepository.findAll()
				.stream()
				.map(borrow->modelMapper.map(borrow, BorrowResponse.class))
				.toList();
	}
}
