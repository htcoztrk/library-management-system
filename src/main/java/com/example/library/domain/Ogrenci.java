package com.example.library.domain;

import javax.persistence.Entity;

@Entity
public class Ogrenci extends User{

	private String faculty;

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
}
