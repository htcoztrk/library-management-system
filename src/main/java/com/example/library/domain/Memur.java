package com.example.library.domain;

import javax.persistence.Entity;

@Entity
public class Memur extends User{
 private String sicilNo;

public String getSicilNo() {
	return sicilNo;
}

public void setSicilNo(String sicilNo) {
	this.sicilNo = sicilNo;
}
 
}
