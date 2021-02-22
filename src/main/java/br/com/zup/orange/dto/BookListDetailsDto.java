package br.com.zup.orange.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zup.orange.controller.validator.UniqueValue;
import br.com.zup.orange.model.Author;
import br.com.zup.orange.model.Book;
import br.com.zup.orange.model.Category;

public class BookListDetailsDto {

	private Long id;

	private String title;

	private String abstract_book;

	private String sumary;

	private BigDecimal price;

	private int numberOfPages;

	private String isbn;

	private AuthorResponseDto author;

	private Category category;

	public BookListDetailsDto(Book book) {
		this.id = book.getId();
		this.title = book.getTitle();
		this.abstract_book = book.getAbstract_book();
		this.sumary = book.getSumary();
		this.price = book.getPrice();
		this.numberOfPages = book.getNumberOfPages();
		this.isbn = book.getIsbn();
		this.author = new AuthorResponseDto(book.getAuthor());
		this.category = book.getCategory();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAbstract_book() {
		return abstract_book;
	}

	public String getSumary() {
		return sumary;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public String getIsbn() {
		return isbn;
	}

	public AuthorResponseDto getAuthor() {
		return author;
	}

	public Category getCategory() {
		return category;
	}

}
