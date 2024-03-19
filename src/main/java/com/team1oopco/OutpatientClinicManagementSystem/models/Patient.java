package com.team1oopco.OutpatientClinicManagementSystem.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "patientno")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientno;
	private String patientName;
	private Integer age;
	private String gender;
	private String nok;
	private String address;
	
	/*@OneToMany(mappedBy="patient")
	private List<Appointment> appointments;*/
	
	public Patient(Integer patientno, String patientName, Integer age, String gender, String nok, String address) {
		this.patientno = patientno;
		this.patientName = patientName;
		this.age = age;
		this.gender = gender;
		this.nok = nok;
		this.address = address;
		//this.appointments = appointments;
	}

	public Patient() {
	}

	public Integer getPatientno() {
		return patientno;
	}

	public void setPatientno(Integer patientno) {
		this.patientno = patientno;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNok() {
		return nok;
	}

	public void setNok(String nok) {
		this.nok = nok;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	/*public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}*/

	@Override
	public String toString() {
		return "Patient [patientno=" + patientno + ", patientName=" + patientName + ", age=" + age + ", gender="
				+ gender + ", nok=" + nok + ", address=" + address + "]";
	}

	/*public String editPatient() {
		System.out.println("Method to update existing patients!");
		
		String Success = "Patient Updated Successfully";
		return Success;
	}*/
}
