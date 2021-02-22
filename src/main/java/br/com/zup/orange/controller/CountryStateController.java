package br.com.zup.orange.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orange.dto.CountryFormInDto;
import br.com.zup.orange.dto.StateFormInDto;
import br.com.zup.orange.model.Country;
import br.com.zup.orange.model.State;

@RestController
@Validated
public class CountryStateController {

	@PersistenceContext // Create a unique EntityManager for each Thread. @Autowired is not thread-safe.
	private EntityManager entityManager;

	@PostMapping("/countries")
	@Transactional
	public CountryFormInDto addCountry(@Valid @RequestBody CountryFormInDto countryDto) {

		Country country = countryDto.toModel();
		entityManager.persist(country);
		return countryDto;

	}
	
	@PostMapping("/states")
	@Transactional
	public String addState(@Valid @RequestBody StateFormInDto stateDto) {
		State newState = stateDto.toModel(entityManager);
		entityManager.persist(newState);
		return newState.toString();

	}

}
