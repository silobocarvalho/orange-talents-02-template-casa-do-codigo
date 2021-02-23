package br.com.zup.orange.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String documentNumber;

	@NotBlank
	private String address;

	@NotBlank
	private String addressComplement;

	@NotBlank
	private String city;

	@NotNull
	@ManyToOne
	private Country country;

	@NotBlank
	private String phone;

	@NotEmpty
	private String postalCode;

	public Client(@NotBlank String firstName, @NotBlank String lastName, @NotBlank @Email String email,
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

}
