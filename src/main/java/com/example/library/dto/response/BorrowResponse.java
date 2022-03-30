package com.example.library.dto.response;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowResponse {

	private LocalDate borrowedDate;
	private LocalDate expectedDeliverDate;
	private LocalDate deliveredDate;
	
}
