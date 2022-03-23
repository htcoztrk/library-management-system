package com.example.library.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Graduate extends Student {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate graduatedDate;

	public LocalDate getGraduatedDate() {
		return graduatedDate;
	}

	public void setGraduatedDate(LocalDate graduatedDate) {
		this.graduatedDate = graduatedDate;
	}
	
	

	
}
