package br.com.zup.orange.dto;

import javax.validation.constraints.NotBlank;

import br.com.zup.orange.controller.validator.UniqueValue;
import br.com.zup.orange.model.Category;

public class CategoryFormInDto {

	@NotBlank
	@UniqueValue(domainClass=Category.class, fieldName="name")
	private String name;
	
	@Deprecated
	public CategoryFormInDto() {		};
	
	public CategoryFormInDto(String name) {	
		this.name = name;
	};
	
	public String getName() {
		return name;
	}
	
	public Category ConvertToModel() {
		return new Category(this.getName());
	}
	
}
