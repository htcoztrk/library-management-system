package com.example.library.dto.response;

import java.util.Objects;

public class AuthorResponse {
	
	private Long id;
	private String fullName;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public AuthorResponse() {
		
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	
	
	
}
