package com.example.library.dto.request;

import java.util.Objects;

import lombok.Data;

public class AuthorAddRequest {

	//private Long id;
	private String fullName;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



//	@Override
//	public int hashCode() {
//		return Objects.hash(id);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		AuthorRequest other = (AuthorRequest) obj;
//		return Objects.equals(id, other.id);
//	}

	public AuthorAddRequest() {
		
	}
	
	
}
