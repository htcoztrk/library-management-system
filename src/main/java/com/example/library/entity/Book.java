package com.example.library.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data

@Entity
@Table(name="books")
@DynamicUpdate
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message="name can not be null")
	@NotBlank(message="name can not be blank")
	private String  isbn;
	@ManyToOne()
	@JoinColumn(name="author_id")
	private Author author;
	@NotNull(message="name can not be null")
	@NotBlank(message="name can not be blank")
	private String title;
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate pressDate;
	@ManyToOne()
	@JoinColumn(name="publisher_id")
	private Publisher publisher;
	@Enumerated
	private BookType bookType;
	private boolean isBorrowed;
	private boolean isReserved;
	
	
}
