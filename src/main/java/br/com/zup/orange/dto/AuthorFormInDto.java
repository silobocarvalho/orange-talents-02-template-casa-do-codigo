package br.com.zup.orange.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zup.orange.controller.validator.UniqueValue;
import br.com.zup.orange.model.Author;

public class AuthorFormInDto {

	@NotBlank(message = "Author name must not be empty.")
	private String name;
	
	@NotNull @Email(message = "Insert a valid email.")
	@UniqueValue(domainClass=Author.class, fieldName="email")
	private String email;
	
	@NotBlank @Size(max = 400, message = "Description should be 400 characters maximum.")
	private String description;
	
	public AuthorFormInDto(String name, String email, String description) {
		this.name = name;
		this.email = email;
		this.description = description;
	}

	public Author ConvertToModel() {
		return new Author(this.getName(), this.getEmail(), this.description);
	}
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getDescription() {
		return description;
	}
	
	
	
}
