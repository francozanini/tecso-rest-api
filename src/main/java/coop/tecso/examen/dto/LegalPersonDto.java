package coop.tecso.examen.dto;

import java.io.Serializable;
import java.time.Year;

public class LegalPersonDto implements Serializable{


	private static final long serialVersionUID = 6063733338835895092L;
	
	private Long id;	
	private Long cuit;
	private Year firstYearOfBusiness;
	private String businessName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCuit() {
		return cuit;
	}
	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}
	
	public Year getFirstYearOfBusiness() {
		return firstYearOfBusiness;
	}
	public void setFirstYearOfBusiness(Year firstYearOfBusiness) {
		this.firstYearOfBusiness = firstYearOfBusiness;
	}
	
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
}
