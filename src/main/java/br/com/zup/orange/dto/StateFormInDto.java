package br.com.zup.orange.dto;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.orange.controller.validator.ExistsId;
import br.com.zup.orange.controller.validator.UniqueStateCountryName;
import br.com.zup.orange.controller.validator.UniqueValue;
import br.com.zup.orange.model.Country;
import br.com.zup.orange.model.State;

@UniqueStateCountryName(domainClass = State.class, stateName = "name", countryId = "country_id")
public class StateFormInDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ExistsId(domainClass = Country.class, fieldName = "id")
	private Long country_id;
	
	@NotBlank
	
	private String name;

	@Deprecated
	public StateFormInDto() {
	}

	public StateFormInDto(String name, Long country_id) {
		this.name = name;
		this.country_id = country_id;
	}

	public State toModel(EntityManager entityManager) {
		@NotNull Country countryFromDb = entityManager.find(Country.class, this.country_id);
		return new State(this.name, countryFromDb);
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public Long getCountry_id() {
		return country_id;
	}

}
