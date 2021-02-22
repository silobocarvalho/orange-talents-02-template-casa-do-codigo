package br.com.zup.orange.model;

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

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String title;

	@NotBlank
	@Size(max = 500)
	private String abstract_book;

	private String sumary;

	@NotNull
	@Min(value = 20)
	private BigDecimal price;

	@NotNull
	@Min(value = 100)
	private int numberOfPages;

	@NotEmpty
	private String isbn;

	@NotNull
	@Future
	private LocalDate publicationDate;

	@NotNull
	@ManyToOne
	private Author author;

	@NotNull
	@ManyToOne
	private Category category;
	
	@Deprecated
	public Book() {}

	public Book(@NotBlank String title, @NotBlank @Size(max = 500) String abstract_book, String sumary,
			@NotNull @Min(20) BigDecimal price, @NotNull @Min(100) int numberOfPages, @NotEmpty String isbn,
			@NotNull @Future LocalDate publicationDate, @NotNull Author author, @NotNull Category category) {
		this.title = title;
		this.abstract_book = abstract_book;
		this.sumary = sumary;
		this.price = price;
		this.numberOfPages = numberOfPages;
		this.isbn = isbn;
		this.publicationDate = publicationDate;
		this.author = author;
		this.category = category;
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

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public Author getAuthor() {
		return author;
	}

	public Category getCategory() {
		return category;
	}

}
