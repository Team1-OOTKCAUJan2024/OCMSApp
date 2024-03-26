package com.team1oopco.OutpatientClinicManagementSystem.models;

import java.util.Scanner;  // Import the Scanner class for user input

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime; // Import the LocalDateTime class to save dates
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class to format the time

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "prescriptionid")
public class Prescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer prescriptionid;
	public String medicine;
	private Integer quantity;
	private Float unitprice;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="pharmacyid", insertable=false, updatable=false)
    private Pharmacy pharmacy;
    private Integer pharmacyid;
    
	public Prescription(Integer prescriptionid, String medicine, Integer quantity, Float unitprice, String status, Pharmacy pharmacy,
			Integer pharmacyid) {
		this.prescriptionid = prescriptionid;
		this.medicine = medicine;
		this.quantity = quantity;
		this.unitprice = unitprice;
		this.status = status;
		this.pharmacy = pharmacy;
		this.pharmacyid = pharmacyid;
	}

	public Prescription() {
	}

	public Integer getPrescriptionid() {
		return prescriptionid;
	}

	public void setPrescriptionid(Integer prescriptionid) {
		this.prescriptionid = prescriptionid;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Float unitprice) {
		this.unitprice = unitprice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public Integer getPharmacyid() {
		return pharmacyid;
	}

	public void setPharmacyid(Integer pharmacyid) {
		this.pharmacyid = pharmacyid;
	}

	@Override
	public String toString() {
		return "Prescription [prescriptionid=" + prescriptionid + ", medicine=" + medicine + ", quantity=" + quantity
				+ ", unitprice=" + unitprice + ", status=" + status + ", pharmacy=" + pharmacy + ", pharmacyid=" + pharmacyid + "]";
	}
     
    
    //Figure out the connection with Billing.
	
	/*public void prescription() {
		  //some code to go here
		}
	
	public void viewPharmacy() {
		  //some code to go here
		}
	
	public void issueMedication() {
		
		}*/
}
