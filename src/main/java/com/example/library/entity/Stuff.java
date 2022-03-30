package com.example.library.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Stuff {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String pinCode;
	private String name;
	private String surname;
	private String email;
	private String phone;
	private LocalDate registeredDate = LocalDate.now();
	private int borrowedBookNum;
	private String sicilNo;
	@Enumerated
	private StuffType stuffType;
}