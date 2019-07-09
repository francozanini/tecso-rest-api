package coop.tecso.examen.dto;

import java.io.Serializable;
import java.time.Year;

public class UpdateLegalPersonDto implements Serializable{


	private static final long serialVersionUID = 5819410716957028857L;
	private Long cuit;
	private Year firstYearOfBusiness;
	private String businessName;
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
