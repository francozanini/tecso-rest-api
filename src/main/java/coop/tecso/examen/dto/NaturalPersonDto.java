package coop.tecso.examen.dto;

import java.io.Serializable;

public class NaturalPersonDto implements Serializable {

	private static final long serialVersionUID = -6872384206047916318L;
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private Long cuit;
	
	private Long dni;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public Long getCuit() {
		return cuit;
	}

	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

	
}
