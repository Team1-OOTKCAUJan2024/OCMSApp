package com.team1oopco.OutpatientClinicManagementSystem.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pharmacyid")
public class Pharmacy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pharmacyid;
    
    @ManyToOne
    @JoinColumn(name="personnelid", insertable=false, updatable=false)
    private MedicalStaff medicalstaff;
    private Integer personnelid;
    
    @OneToOne
    @JoinColumn(name="consultationid", insertable=false, updatable=false)
    private DoctorConsultation doctorConsultation;
    private Integer consultationid;
    
    /*@OneToMany(mappedBy="pharmacy")
    private List<Prescription> prescriptions;*/
    
	public Pharmacy(Integer pharmacyid, MedicalStaff medicalstaff, Integer personnelid, DoctorConsultation doctorConsultation,
			Integer consultationid) {
		this.pharmacyid = pharmacyid;
		this.medicalstaff = medicalstaff;
		this.personnelid = personnelid;
		this.doctorConsultation = doctorConsultation;
		this.consultationid = consultationid;
		//this.prescriptions = prescriptions;
	}

	public Pharmacy() {
	}

	public Integer getPharmacyid() {
		return pharmacyid;
	}

	public void setPharmacyid(Integer pharmacyid) {
		this.pharmacyid = pharmacyid;
	}

	public MedicalStaff getMedicalStaff() {
		return medicalstaff;
	}

	public void setMedicalStaff(MedicalStaff medicalstaff) {
		this.medicalstaff = medicalstaff;
	}

	public Integer getPersonnelid() {
		return personnelid;
	}

	public void setPersonnelid(Integer personnelid) {
		this.personnelid = personnelid;
	}

	public DoctorConsultation getDoctorConsultation() {
		return doctorConsultation;
	}

	public void setDoctorConsultation(DoctorConsultation doctorConsultation) {
		this.doctorConsultation = doctorConsultation;
	}

	public Integer getConsultationid() {
		return consultationid;
	}

	public void setConsultationid(Integer consultationid) {
		this.consultationid = consultationid;
	}

	/*public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}*/

	@Override
	public String toString() {
		return "Pharmacy [pharmacyid=" + pharmacyid + ", medicalstaff=" + medicalstaff + ", personnelid=" + personnelid
				+ ", doctorConsultation=" + doctorConsultation + ", consultationid=" + consultationid
				+ "]";
	}

	// Method to view pharmacy request
    /*public String viewPharmacyRequest() {
        // Implementation to view pharmacy request
        return "Pharmacy request viewed";
    }

    // Method to issue medication based on a prescription
    public String issueMedication(Prescription prescription) {
        // Implementation to issue medication
        return "Medication issued based on the prescription";
    }*/
}