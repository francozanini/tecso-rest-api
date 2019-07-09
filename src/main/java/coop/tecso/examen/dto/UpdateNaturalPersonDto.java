package coop.tecso.examen.dto;

import java.io.Serializable;

public class UpdateNaturalPersonDto implements Serializable {

	private static final long serialVersionUID = 6991857527476727173L;

	private String firstName;
	
	private String lastName;
	
	private Long cuit;
	
	private Long dni;

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

	public Long getCuit() {
		return cuit;
	}

	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

}
