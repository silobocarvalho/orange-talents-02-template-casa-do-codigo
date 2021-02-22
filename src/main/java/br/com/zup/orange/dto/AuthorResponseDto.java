package br.com.zup.orange.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zup.orange.model.Author;

public class AuthorResponseDto {

	private Long id;

	private String name;

	private String description;

	public AuthorResponseDto(Author author) {
		this.id = author.getId();
		this.name = author.getName();
		this.description = author.getDescription();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
