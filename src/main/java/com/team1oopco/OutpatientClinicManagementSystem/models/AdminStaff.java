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
public class AdminStaff extends Personnel {

	private String department;
	private String role;
	
	/*@OneToMany(mappedBy="adminstaff")
	private List<Appointment> appointments;*/
	
	public AdminStaff(int personnelid, String personnelName, String address, int telephone, String department,
			String role) {
		this.department = department;
		this.role = role;
		//this.appointments = appointments;
	}
	
	public AdminStaff() {
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/*public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}*/

	@Override
	public String toString() {
		return "AdminStaff [department=" + department + ", role=" + role + "]";
	}
}
