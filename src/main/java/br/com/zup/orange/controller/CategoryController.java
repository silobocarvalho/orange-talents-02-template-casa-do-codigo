package br.com.zup.orange.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orange.dto.CategoryFormInDto;
import br.com.zup.orange.model.Category;

@RestController
@RequestMapping("/categories")
@Validated
public class CategoryController {

	@PersistenceContext //Create a unique EntityManager for each Thread. @Autowired is not thread-safe.
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public void addCategory(@RequestBody @Valid CategoryFormInDto categoryFormInDto) {
		Category category = categoryFormInDto.ConvertToModel();
		entityManager.persist(category);
		
	}

}
