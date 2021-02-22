package br.com.zup.orange.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.orange.model.Book;

public class BookListDto {
	
	@NotNull
	private Long id;
	
	@NotBlank
	private String title;
	
	public BookListDto(Book book) {
		this.id = book.getId();
		this.title = book.getTitle();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	
	
}
