package com.team1oopco.OutpatientClinicManagementSystem.models;

import java.util.List;
import java.util.Scanner;  // Import the Scanner class for user input

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime; // Import the LocalDateTime class to save dates
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class to format the time

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "consultationid")
public class DoctorConsultation extends Consultation {
	public String medicalHistory;
	public String diagnosis;
	public String[] labTests;
	public String[] prescriptions;
	public String doctorNotes;
	public Integer consultationfee;
	
	@OneToOne
	@JoinColumn(name="appointmentid", insertable=false, updatable=false)
	private Appointment appointment;
	private Integer appointmentid;
	
	public DoctorConsultation(Integer consultationid, String consultationRoom, String status, String timestamp,
			Personnel personnel, int personnelid, String medicalHistory, Integer consultationfee,
			String diagnosis, String[] labTests, String[] prescriptions, String doctorNotes, Appointment appointment, Integer appointmentid) {
		
		this.medicalHistory = medicalHistory;
		this.diagnosis = diagnosis;
		this.labTests = labTests;
		this.prescriptions = prescriptions;
		this.doctorNotes = doctorNotes;
		this.consultationfee = consultationfee;
		this.appointment = appointment;
		this.appointmentid = appointmentid;
	}

	public DoctorConsultation(Integer consultationid, String consultationRoom, String status, String timestamp,
			Personnel personnel, int personnelid) {
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String[] getLabTests() {
		return labTests;
	}

	public void setLabTests(String[] labTests) {
		this.labTests = labTests;
	}
	

	public String[] getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(String[] prescriptions) {
		this.prescriptions = prescriptions;
	}

	public String getDoctorNotes() {
		return doctorNotes;
	}

	public void setDoctorNotes(String doctorNotes) {
		this.doctorNotes = doctorNotes;
	}
	

	public Integer getConsultationfee() {
		return consultationfee;
	}

	public void setConsultationfee(Integer consultationfee) {
		this.consultationfee = consultationfee;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Integer getAppointmentid() {
		return appointmentid;
	}

	public void setAppointmentid(Integer appointmentid) {
		this.appointmentid = appointmentid;
	}

	@Override
	public String toString() {
		return "DoctorConsultation [medicalHistory=" + medicalHistory + ", diagnosis=" + diagnosis + ", labTests="
				+ labTests + ", prescriptions=" + prescriptions + ", doctorNotes=" + doctorNotes + ", consultationfee=" + consultationfee + ", appointment=" + appointment + ", appointmentid=" + appointmentid + "]";
	}
	
	
	/*public void doctorConsultation() {
		  //some code to go here
		}
	
	public void prescribeMedication() {
		Scanner userInput = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter Medication prescribed ");

		doctorNotes = userInput.nextLine();  // Read user input
		}
	
	public void orderLabTest() {
		Scanner userInput = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter Lab Tests Required");

		labTests = userInput.nextLine();  // Read user input
		}
	public void viewConsultation() {
		  //some code to go here
		//
		}
	public void editConsultation() {
		  //some code to go here
		//
		}
	public void viewLabReport() {
		  //some code to go here
		//
		}*/
}
