package coop.tecso.examen.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public class Titular {

	private static final long serialVersionUID = 7103682493293376917L;

	@Id
	private Long id;
	
	@Column(name = "cuit", unique = true)
	protected String cuit;

	@OneToOne(cascade = CascadeType.ALL)
	LegalPerson legalPerson;
	
	@OneToOne(mappedBy = "titular")
	NaturalPerson naturalPerson;
	
	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
}
