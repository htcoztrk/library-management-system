package com.example.library.dto.request;

import java.time.LocalDate;

import com.example.library.entity.Book;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReservationRequest {
	private Book book;
	private LocalDate reservedDate;
	private LocalDate dueDate;
}
