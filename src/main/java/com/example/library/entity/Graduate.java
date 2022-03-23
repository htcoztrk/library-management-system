package com.example.library.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Graduate extends Student{
   private LocalDateTime graduatedYear;

public LocalDateTime getGraduatedYear() {
	return graduatedYear;
}

public void setGraduatedYear(LocalDateTime graduatedYear) {
	this.graduatedYear = graduatedYear;
}

}
