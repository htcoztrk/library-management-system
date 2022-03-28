package com.example.library.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="borrows")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate borrowedDate;
	private LocalDate expectedDeliverDate;
	private LocalDate deliveredDate;
	@ManyToOne
	private User user;
	@ManyToOne
	private Book book;
	
}
