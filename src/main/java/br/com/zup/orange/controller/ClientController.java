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

import br.com.zup.orange.dto.ClientFormInDto;
import br.com.zup.orange.model.Client;

@RestController
@RequestMapping("/clients")
@Validated
public class ClientController {

	@PersistenceContext // Create a unique EntityManager for each Thread. @Autowired is not thread-safe.
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public void addClient(@Valid @RequestBody ClientFormInDto clientFormIn){
		
		Client newClient = clientFormIn.toModel(entityManager);
		
		entityManager.persist(newClient);
	}
}
