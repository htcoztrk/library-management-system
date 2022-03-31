package com.example.library.utilities.rules;

import com.example.library.entity.Book;
import com.example.library.entity.BookType;
import com.example.library.entity.Student;

public class StudentBorrowRules {

	public static BorrowRuleResult borrow(Book book, Student student) {
		System.err.println("deneme borrowed number: " + student.getBorrowedBookNum());
		System.err.println("deneme is active: " + student.isActive());
		if (student.getBorrowedBookNum() == 3 && student.isActive()) {
			return new BorrowRuleResult(false, "Already has 3 books", null);
		}
		if ((!student.isActive()) && student.getBorrowedBookNum() == 1)
			return new BorrowRuleResult(false, "Already has 1 books", null);
		if (!(book.getBookType().equals(BookType.NORMAL)))
			return new BorrowRuleResult(false, "Student can borrow only normal book.", null);
		return new BorrowRuleResult(true, "Borrow rule is success", null);
	}

}
