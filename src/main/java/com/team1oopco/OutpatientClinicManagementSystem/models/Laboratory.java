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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "labno")
public class Laboratory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer labno;
    
    @ManyToOne
    @JoinColumn(name="personnelid", insertable=false, updatable=false)
    private MedicalStaff medicalstaff;
    private Integer personnelid;
    
    @OneToOne
    @JoinColumn(name="consultationid", insertable=false, updatable=false)
    private DoctorConsultation doctorConsultation;
    private Integer consultationid;
    
	public Laboratory(Integer labno, MedicalStaff medicalstaff, Integer personnelid, DoctorConsultation doctorConsultation,
			Integer consultationid) {
		this.labno = labno;
		this.medicalstaff = medicalstaff;
		this.personnelid = personnelid;
		this.doctorConsultation = doctorConsultation;
		this.consultationid = consultationid;
	}

	public Laboratory() {
	}

	public Integer getLabno() {
		return labno;
	}

	public void setLabno(Integer labno) {
		this.labno = labno;
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

	@Override
	public String toString() {
		return "Pharmacy [labno=" + labno + ", medicalstaff=" + medicalstaff + ", personnelid=" + personnelid
				+ ", doctorConsultation=" + doctorConsultation + ", consultationid=" + consultationid
				+ "]";
	}

	
}