package com.team1oopco.OutpatientClinicManagementSystem.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "appointmentid")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer appointmentid;
	public String appointmentDate;
	public String appointmentTime;
	public String status;
	
	@ManyToOne
	@JoinColumn(name="personnelid", insertable=false, updatable=false)
	private AdminStaff adminstaff;
	private Integer personnelid;
	
	@ManyToOne
	@JoinColumn(name="patientno", insertable=false, updatable=false)
	private Patient patient;
	private Integer patientno;
	
	/*@OneToOne(mappedBy="appointment")
	private List<Triage> triages;*/

	public Appointment(Integer appointmentid, String appointmentDate, String appointmentTime, String status,
			AdminStaff adminstaff, Integer personnelid, Patient patient, Integer patientno) {
		this.appointmentid = appointmentid;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.status = status;
		this.adminstaff = adminstaff;
		this.personnelid = personnelid;
		this.patient = patient;
		this.patientno = patientno;
		//this.triages = triages;
	}

	public Appointment() {
	}

	public Integer getAppointmentid() {
		return appointmentid;
	}

	public void setAppointmentid(Integer appointmentid) {
		this.appointmentid = appointmentid;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Personnel getAdminStaff() {
		return adminstaff;
	}

	public void setAdminStaff(AdminStaff adminstaff) {
		this.adminstaff = adminstaff;
	}

	public Integer getPersonnelid() {
		return personnelid;
	}

	public void setPersonnelid(Integer personnelid) {
		this.personnelid = personnelid;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Integer getPatientno() {
		return patientno;
	}

	public void setPatientno(Integer patientno) {
		this.patientno = patientno;
	}

	/*public List<Triage> getTriage() {
		return triages;
	}

	public void setDoctorConsultations(List<DoctorConsultation> doctorconsultations) {
		this.triages = triages;
	}*/

	@Override
	public String toString() {
		return "Appointment [appointmentid=" + appointmentid + ", appointmentDate=" + appointmentDate
				+ ", appointmentTime=" + appointmentTime + ", status=" + status + ", adminstaff=" + adminstaff
				+ ", personnelid=" + personnelid + ", patient=" + patient + ", patientno=" + patientno + "]";
	}
	
	
	
	/*public void bookAppointment (String Date, String time, String ID, String Number, String Booked) {
		System.out.print ("method to book an appointment!");
		
		appointmentDate = Date;
		appointmentTime = time;
		personelID = ID;
		patientNo = Number;
		status = Booked;
		
		// insert booking details into database
		
		System.out.print (" Appointment Booking Successfull!");
	}
	
	public void cancelBooking() {
		System.out.println("Method to cancel existing bookings");
	}*/
	
}