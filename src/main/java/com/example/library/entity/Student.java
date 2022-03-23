package com.example.library.entity;

import javax.persistence.Entity;

@Entity
public class Student extends User{

	private String faculty;

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
}
