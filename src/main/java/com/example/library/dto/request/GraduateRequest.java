package com.example.library.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraduateRequest {
	private String username;
	private String password;
	private String pinCode;
	private String name;
	private String surname;
	private String email;
	private String phone;
	private String faculty;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate graduatedDate;
	
}
