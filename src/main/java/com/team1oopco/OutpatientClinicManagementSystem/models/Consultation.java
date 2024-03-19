package com.team1oopco.OutpatientClinicManagementSystem.models;

import java.util.List;
import java.util.Scanner;  // Import the Scanner class for user input

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime; // Import the LocalDateTime class to save dates
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class to format the time

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "consultationid")
public class Consultation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer consultationid;
	//public String prescriptionID;
	public String consultationRoom;
	//public String patient;
	public String status;
	//public String personnel;
	public String timestamp;
	
	@ManyToOne
	@JoinColumn(name="personnelid", insertable=false, updatable=false)
	protected MedicalStaff medicalstaff;
	protected Integer personnelid;
	
	
	public Consultation(Integer consultationid, String consultationRoom, String status,
			String timestamp, MedicalStaff medicalstaff, int personnelid, Integer appointmentid) {
		this.consultationid = consultationid;
		this.consultationRoom = consultationRoom;
		this.status = status;
		this.timestamp = timestamp;
		this.medicalstaff = medicalstaff;
		this.personnelid = personnelid;
	}

	public Consultation() {
	}

	public Integer getConsultationid() {
		return consultationid;
	}

	public void setConsultationid(Integer consultationid) {
		this.consultationid = consultationid;
	}

	public String getConsultationRoom() {
		return consultationRoom;
	}

	public void setConsultationRoom(String consultationRoom) {
		this.consultationRoom = consultationRoom;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public MedicalStaff getMedicalStaff() {
		return medicalstaff;
	}

	public void setMedicalStaff(MedicalStaff medicalstaff) {
		this.medicalstaff = medicalstaff;
	}

	public int getPersonnelid() {
		return personnelid;
	}

	public void setPersonnelid(int personnelid) {
		this.personnelid = personnelid;
	}

	@Override
	public String toString() {
		return "Consultation [consultationid=" + consultationid + ", consultationRoom="
				+ consultationRoom + ", status=" + status + ", timestamp=" + timestamp + ", medicalstaff=" + medicalstaff
				+ ", personnelid=" + personnelid + "]";
	}
	
	
	/* >@OneToMany(mappedBy="consultation")
	private List<Prescription> prescriptions;
	*/
	
	/*public void consultation() {
		  //some code to go here
		}
	
	public void getPersonnel() {
		  //some code to go here
		}
	
	public void getBilling() {
		  //some code to go here
		//
		}*/
}