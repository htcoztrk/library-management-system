package com.example.library.dto.request;

import java.time.LocalDate;

import com.example.library.entity.BookType;

public class BookRequest {
	private String  isbn;
	private String title;
	private LocalDate pressDate;
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
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getPressDate() {
		return pressDate;
	}
	public void setPressDate(LocalDate pressDate) {
		this.pressDate = pressDate;
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
