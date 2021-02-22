package br.com.zup.orange.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Author {


	@Deprecated
	public Author() {};
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@NotBlank @Email
	private String email;

	@NotBlank
	@Size(max = 400)
	private String description;

	private LocalDateTime registerDate = LocalDateTime.now();

	public Author(String name, String email, String description) {
		
		this.name = name;
		this.email = email;
		this.description = description;
	}

	public Long getId() {
		return id;
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

	public LocalDateTime getRegisterDate() {
		return registerDate;
	}
	
	

}
