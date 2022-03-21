package com.example.library.entity;

import javax.persistence.Entity;

@Entity
public class Officer extends User{
 private String sicilNo;

public String getSicilNo() {
	return sicilNo;
}

public void setSicilNo(String sicilNo) {
	this.sicilNo = sicilNo;
}
 
}
