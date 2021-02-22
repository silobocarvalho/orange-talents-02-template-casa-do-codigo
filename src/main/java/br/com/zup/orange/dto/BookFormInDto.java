package br.com.zup.orange.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.orange.controller.validator.UniqueValue;
import br.com.zup.orange.model.Author;
import br.com.zup.orange.model.Book;
import br.com.zup.orange.model.Category;

public class BookFormInDto {

	@NotBlank
	@UniqueValue(domainClass = Book.class, fieldName = "title")
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
	@UniqueValue(domainClass = Book.class, fieldName = "isbn")
	private String isbn;

	@NotNull
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	@JsonProperty("publication_date")
	private LocalDate publicationDate;

	@NotNull
	@ManyToOne
	private Author author;

	@NotNull
	@ManyToOne
	private Category category;

	//Validation here is not necessary, but Eclipse IDE generated automatically, so, its fine to keep that.
	public BookFormInDto(@NotBlank String title, @NotBlank @Size(max = 500) String abstract_book, String sumary,
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

	@Transactional
	public Book convertToModel(EntityManager entityManager) {
		
		@NotNull Author authorFromDb = entityManager.find(Author.class, author.getId());
		@NotNull Category categoryFromDb = entityManager.find(Category.class, category.getId());
		

		/* 
		 * Assert.isNull(authorFromDb, "Author is not defined.");
		 * Assert.isNull(categoryFromDb, "Category is not defined.");
		 */
		
		
		author = authorFromDb;
		category = categoryFromDb;
		
		return new Book(this.title, this.abstract_book, this.sumary, this.price, this.numberOfPages, this.isbn, this.publicationDate, this.author, this.category);
	}
	
	public String toString() {
		return this.title + " - " + this.abstract_book + " - " + this.sumary + " - " + this.price + " - " + this.numberOfPages + " - " + this.isbn + " - " + this.publicationDate + " - " + this.author.getId() + " - " + this.category.getId();
	}
	
	

}
