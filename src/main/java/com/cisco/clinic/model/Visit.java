package com.cisco.clinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Visit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String petName;
    private String ownerName;
    private String visitDate;
    private String reason;
    public Visit() {}
	public Visit(String petName, String ownerName, String visitDate, String reason) {
		super();
		this.petName = petName;
		this.ownerName = ownerName;
		this.visitDate = visitDate;
		this.reason = reason;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Visit [id=" + id + ", petName=" + petName + ", ownerName=" + ownerName + ", visitDate=" + visitDate
				+ ", reason=" + reason + "]";
	}
    

}
