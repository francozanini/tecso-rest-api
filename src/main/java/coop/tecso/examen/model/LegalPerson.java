package coop.tecso.examen.model;

import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "legal_person")
public class LegalPerson extends AbstractPersistentObject
{

	private static final long serialVersionUID = 265357595511682231L;
	
	@Column(name = "cuit", unique = true)
	private Long cuit;
	
	@Column(name = "first_year_of_business")
	private Year firstYearOfBusiness;
	
	@Column(name = "business_name", length = 100)
	private String businessName;

	public LegalPerson() {}
	
	public LegalPerson(String businessName, Long cuit, Year firstYearOfBusiness)
	{
		this.businessName = businessName;
		this.cuit = cuit;
		this.firstYearOfBusiness = firstYearOfBusiness;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public Year getFirstYearOfBusiness() {
		return firstYearOfBusiness;
	}

	public void setFirstYearOfBusiness(Year firstYearOfBusiness) {
		this.firstYearOfBusiness = firstYearOfBusiness;
	}

	public Long getCuit() {
		return cuit;
	}

	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

}
