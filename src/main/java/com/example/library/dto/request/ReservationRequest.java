package com.example.library.dto.request;

import java.time.LocalDate;

import com.example.library.entity.Book;
import com.example.library.entity.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReservationRequest {
	private Book book;
	private User user;
	private LocalDate reservedDate;
	private LocalDate dueDate;
}
