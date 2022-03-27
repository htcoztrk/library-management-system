package com.example.library.dto.request;

import java.time.LocalDate;

import com.example.library.entity.Author;
import com.example.library.entity.BookType;
import com.example.library.entity.Category;
import com.example.library.entity.Publisher;

public class BookRequest {
	private String  isbn;
	private Author author;
	private String title;
	private Category category;
	private LocalDate pressDate;
	private Publisher publisher;
	private BookType bookType;
	private boolean isBorrowed;
	private boolean isReserved;
	
	
	public BookRequest() {
		super();
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public LocalDate getPressDate() {
		return pressDate;
	}
	public void setPressDate(LocalDate pressDate) {
		this.pressDate = pressDate;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public BookType getBookType() {
		return bookType;
	}
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	public boolean isBorrowed() {
		return isBorrowed;
	}
	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	public boolean isReserved() {
		return isReserved;
	}
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
	

}
