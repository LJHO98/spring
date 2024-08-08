package com.example.bookTest.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BookDto {
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private int bookCost;
	private int bookPage;
	private String publisher;
}
