package com.example.library.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import antlr.collections.List;
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
	//private Author author;
	@NotBlank(message="title can not be blank")
	@NotNull
	private String title;
	private String qrCode;
	//private Date pressDate;
	//private BookType bookType;
	//private Set<Borrow> borrowList;
	
}
