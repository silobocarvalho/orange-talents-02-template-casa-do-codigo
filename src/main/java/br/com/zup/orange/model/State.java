package br.com.zup.orange.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sun.xml.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

@Entity
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@NotNull
	@ManyToOne
	private Country country;

	public State(@NotBlank String name, @NotNull Country country) {
		this.name = name;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Country getCountry() {
		return country;
	}
	
	@Override
	public String toString() {
		return this.getId() + " - " + this.getName() + " - " + this.getCountry().getName();
	}

}
