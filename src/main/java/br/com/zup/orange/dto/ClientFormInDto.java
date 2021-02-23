package br.com.zup.orange.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.zup.orange.controller.validator.CpfOrCnpj;
import br.com.zup.orange.controller.validator.UniqueValue;
import br.com.zup.orange.model.Client;
import br.com.zup.orange.model.Country;

public class ClientFormInDto {

	private Long id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	@Email
	@UniqueValue(domainClass = Client.class, fieldName = "email")
	private String email;

	@NotBlank
	@UniqueValue(domainClass = Client.class, fieldName = "documentNumber")
	@CpfOrCnpj(domainClass = Client.class)
	private String documentNumber;

	@NotBlank
	private String address;

	@NotBlank
	private String addressComplement;

	@NotBlank
	private String city;

	@NotNull
	private Country country;

	@NotBlank
	private String phone;

	@NotEmpty
	@Pattern(regexp = "\\d{5}-\\d{3}")
	private String postalCode;

	public ClientFormInDto(@NotBlank String firstName, @NotBlank String lastName, @NotBlank @Email String email,
			@NotBlank String documentNumber, @NotBlank String address, @NotBlank String addressComplement,
			@NotBlank String city, @NotNull Country country, @NotBlank String phone,
			@NotEmpty @Pattern(regexp = "d{5}-d{3}") String postalCode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.documentNumber = documentNumber;
		this.address = address;
		this.addressComplement = addressComplement;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.postalCode = postalCode;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getAddressComplement() {
		return addressComplement;
	}

	public String getCity() {
		return city;
	}

	public Country getCountry() {
		return country;
	}

	public String getPhone() {
		return phone;
	}

	public String getPostalCode() {
		return postalCode;
	}

	@Override
	public String toString() {
		return "ClientFormInDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", documentNumber=" + documentNumber + ", address=" + address + ", addressComplement="
				+ addressComplement + ", city=" + city + ", country Id=" + country.getId() + ", phone=" + phone + ", postalCode="
				+ postalCode + "]";
	}

	public Client toModel(EntityManager entityManager) {

		@NotNull Country countryFromDb = entityManager.find(Country.class, this.country.getId());
		
		Client client = new Client(this.firstName, this.lastName, this.email, this.documentNumber, this.address, this.addressComplement, this.city, countryFromDb, this.phone, this.postalCode);
		
		return client;
	}
	

}
