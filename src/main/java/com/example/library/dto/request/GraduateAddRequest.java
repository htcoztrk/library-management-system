package com.example.library.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraduateAddRequest {
	private Long userId;
	private String username;
	private String password;
	private String pinCode;
	private String name;
	private String surname;
	private String email;
	private String phone;
	
}
