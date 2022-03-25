package com.example.library.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name="books")
@DynamicUpdate
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="isbn can not be blank")
	private String  isbn;
	@ManyToOne()
	private Author author;
	@NotBlank(message="title can not be blank")
	@NotNull
	private String title;
	private byte[] qrCode;
	private Category category;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate pressDate;
	private Publisher publisher;
	@Enumerated
	private BookType bookType;
	private boolean isBorrowed;
	private boolean isReserved;
}
