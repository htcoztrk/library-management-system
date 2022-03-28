package com.example.library.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity 
@Data
@Table(name = "reservations")
@DynamicUpdate
public class Reservation {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate reservedDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dueDate;
}
