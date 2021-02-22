package br.com.zup.orange.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orange.dto.AuthorFormInDto;
import br.com.zup.orange.model.Author;

@RestController
@Validated
@RequestMapping("/authors")
public class AuthorController {

	@PersistenceContext //Create a unique EntityManager for each Thread. @Autowired is not thread-safe.
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public void addAuthor(@RequestBody @Valid AuthorFormInDto authorDto) {
		
		Author author = authorDto.ConvertToModel(); 
		
		entityManager.persist(author);	
		
	}
	
}
