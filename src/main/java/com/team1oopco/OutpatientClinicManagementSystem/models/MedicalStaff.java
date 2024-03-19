package com.team1oopco.OutpatientClinicManagementSystem.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "personnelid")
public class MedicalStaff extends Personnel {

	private String specialization;
	private String licenseNO;
	
	/*@OneToMany(mappedBy="medicalstaff")
	private List<DoctorConsultation> doctorconsultations;
	
	@OneToMany(mappedBy="medicalstaff")
	private List<Pharmacy> pharmacies;*/
	
	public MedicalStaff(int personnelid, String personnelName, String address, int telephone, String specialization,
			String licenseNO) {
		this.specialization = specialization;
		this.licenseNO = licenseNO;
		/*this.doctorconsultations = doctorconsultations;
		this.pharmacies = pharmacies;*/
	}

	public MedicalStaff(int personnelid, String personnelName, String address, int telephone) {
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getLicenseNO() {
		return licenseNO;
	}

	public void setLicenseNO(String licenseNO) {
		this.licenseNO = licenseNO;
	}

	/*public List<DoctorConsultation> getDoctorConsultations() {
		return doctorconsultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.doctorconsultations = doctorconsultations;
	}
	

	public List<Pharmacy> getPharmacies() {
		return pharmacies;
	}

	public void setPharmacies(List<Pharmacy> pharmacies) {
		this.pharmacies = pharmacies;
	}*/

	@Override
	public String toString() {
		return "MedicalStaff [specialization=" + specialization + ", licenseNO=" + licenseNO + "]";
	}	
	
}
