package br.com.zup.orange.dto;

import javax.validation.constraints.NotBlank;

import br.com.zup.orange.controller.validator.UniqueValue;
import br.com.zup.orange.model.Country;

public class CountryFormInDto {

	@NotBlank
	@UniqueValue(domainClass=Country.class, fieldName="name")
	private String name;

	@Deprecated
	public CountryFormInDto() {}
	
	public CountryFormInDto(String name) {
		this.name = name;
	}
	
	public Country toModel() {
		return new Country(name);
	}

	public String getName() {
		return name;
	}
	
	
}
