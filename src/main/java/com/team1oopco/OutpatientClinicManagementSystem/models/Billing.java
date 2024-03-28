package com.team1oopco.OutpatientClinicManagementSystem.models;

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

//import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "invoiceno")
public class Billing {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer invoiceno;
	private String invoiceDate;
	private int amount;
    private String status;
    
    @ManyToOne
    @JoinColumn(name="personnelid",insertable=false, updatable=false)
    private AdminStaff adminstaff;
    private Integer personnelid;
    
    @ManyToOne
    @JoinColumn(name="patientno", insertable=false, updatable=false)
    private Patient patient;
    private Integer patientno;
    
    @OneToOne
    @JoinColumn(name="consultationid", insertable=false, updatable=false)
    private DoctorConsultation doctorConsultation;
    private Integer consultationid;
    
    @OneToMany
    @JoinColumn(name="prescriptionid", insertable=false, updatable=false)
    private Prescription prescription;
    private Integer prescriptionid;
    
    @OneToMany
    @JoinColumn(name="labtestno", insertable=false, updatable=false)
    private LabTest labTest;
    private Integer labtestno;
    
	public Billing(Integer invoiceno, String invoiceDate, int amount, String status, AdminStaff adminstaff,
			Integer personnelid, Patient patient, Integer patientno, DoctorConsultation doctorConsultation,
			Integer consultationid, Prescription prescription, Integer prescriptionid, LabTest labTest,
			Integer labtestno) {
		this.invoiceno = invoiceno;
		this.invoiceDate = invoiceDate;
		this.amount = amount;
		this.status = status;
		this.adminstaff = adminstaff;
		this.personnelid = personnelid;
		this.patient = patient;
		this.patientno = patientno;
		this.doctorConsultation = doctorConsultation;
		this.consultationid = consultationid;
		this.prescription = prescription;
		this.prescriptionid = prescriptionid;
		this.labTest = labTest;
		this.labtestno = labtestno;
	}

	public Billing() {
	}

	public Integer getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(Integer invoiceno) {
		this.invoiceno = invoiceno;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AdminStaff getAdminstaff() {
		return adminstaff;
	}

	public void setAdminstaff(AdminStaff adminstaff) {
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

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public Integer getPrescriptionid() {
		return prescriptionid;
	}

	public void setPrescriptionid(Integer prescriptionid) {
		this.prescriptionid = prescriptionid;
	}

	public LabTest getLabTest() {
		return labTest;
	}

	public void setLabTest(LabTest labTest) {
		this.labTest = labTest;
	}

	public Integer getLabtestno() {
		return labtestno;
	}

	public void setLabtestno(Integer labtestno) {
		this.labtestno = labtestno;
	}

	@Override
	public String toString() {
		return "Billing [invoiceno=" + invoiceno + ", invoiceDate=" + invoiceDate + ", amount=" + amount + ", status="
				+ status + ", adminstaff=" + adminstaff + ", personnelid=" + personnelid + ", patient=" + patient
				+ ", patientno=" + patientno + ", doctorConsultation=" + doctorConsultation + ", consultationid="
				+ consultationid + ", prescription=" + prescription + ", prescriptionid=" + prescriptionid
				+ ", labTest=" + labTest + ", labtestno=" + labtestno + "]";
	}
}