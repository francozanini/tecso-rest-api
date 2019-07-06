package coop.tecso.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="natural_person")
public class NaturalPerson extends AbstractPersistentObject
{
	
	private static final long serialVersionUID = 7104742805045626828L;
	
	NaturalPerson() {}
	
	NaturalPerson( String firstName,
			String lastName, 
			Long dni, 
			String cuit) 
	{
		this.firstName = firstName;
		this.dni = dni;
		this.lastName = lastName;
	}
			
	@Column(name="first_name", length = 80)
	@NotEmpty(message = "Please provide a name")
	private String firstName;
	
	@Column(name="last_name", length = 250)
	@NotEmpty(message = "Please provide a last name")
	private String lastName;
	
	@Column(name="dni", unique=true)
	@NotNull(message = "Please provide an unique dni")
	private Long dni;
	
	@Column(name = "cuit", unique = true)
	private String cuit;
	
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
}
