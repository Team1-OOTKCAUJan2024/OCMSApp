package com.team1oopco.OutpatientClinicManagementSystem.models;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "consultationid")
public class Triage extends Consultation {
	
	public String[] vitals;
	public String symptoms;
	
	@OneToOne
	@JoinColumn(name="appointmentid", insertable=false, updatable=false)
	private Appointment appointment;
	private Integer appointmentid;
	
	public Triage(Integer consultationid, String consultationRoom, String status, String timestamp,
			MedicalStaff medicalstaff, int personnelid, String[] vitals, String symptoms,
			Appointment appointment, Integer appointmentid) {
		this.vitals = vitals;
		this.symptoms = symptoms;
		this.appointment = appointment;
		this.appointmentid = appointmentid;
	}

	public Triage(Integer consultationid, String consultationRoom, String status, String timestamp,
			MedicalStaff medicalstaff, int personnelid) {
	}

	public String[] getVitals() {
		return vitals;
	}

	public void setVitals(String[] vitals) {
		this.vitals = vitals;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
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
		return "Triage [vitals=" + Arrays.toString(vitals) + ", symptoms=" + symptoms + ", appointment=" + appointment + ", appointmentid=" + appointmentid+ "]";
	}

	/*public void sendToDoctor() {
		System.out.println("Method to send vitals and symptoms to Doctor!");
	}
	
	public void viewTriage() {
		System.out.println("Method to view patients in Triage!");
	}
	
	public void editTriage(String[] _vitals, String _symptoms) {
		System.out.println("Method to update patient vitals and/or symptoms!");
	}
	
	public void deleteTriage() {
		System.out.println("Method to remove patient Triage details!");
	}*/
}
