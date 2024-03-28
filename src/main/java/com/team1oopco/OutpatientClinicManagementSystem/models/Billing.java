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
	private Integer totalAmount;
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
    private Integer consultationfee;
    
    @OneToOne
    @JoinColumn(name="prescriptionid", insertable=false, updatable=false)
    private Prescription prescription;
    private Integer prescriptionid;
    private Integer prescriptionamount;
    
    @OneToOne
    @JoinColumn(name="labtestno", insertable=false, updatable=false)
    private LabTest labtest;
    private Integer labtestno;
    private Integer labtestprice;
    
	public Billing(Integer invoiceno, String invoiceDate, Integer totalAmount, String status, AdminStaff adminstaff,
			Integer personnelid, Patient patient, Integer patientno, DoctorConsultation doctorConsultation,
			Integer consultationid, Integer consultationfee, Prescription prescription, Integer prescriptionid, Integer prescriptionamount, LabTest labtest,
			Integer labtestno, Integer labtestprice) {
		this.invoiceno = invoiceno;
		this.invoiceDate = invoiceDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.adminstaff = adminstaff;
		this.personnelid = personnelid;
		this.patient = patient;
		this.patientno = patientno;
		this.doctorConsultation = doctorConsultation;
		this.consultationid = consultationid;
		this.consultationfee = consultationfee;
		this.prescription = prescription;
		this.prescriptionid = prescriptionid;
		this.prescriptionamount = prescriptionamount;
		this.labtest = labtest;
		this.labtestno = labtestno;
		this.labtestprice = labtestprice;
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

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
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
	
	public Integer getConsultationId() {
		return consultationid;
	}
	
	public void setConsultationId(Integer consultationid) {
		this.consultationid = consultationid;
	}

	public Integer getConsultationFee() {
		return consultationfee;
	}

	public void setConsultationFee(Integer consultationfee) {
		this.consultationfee = consultationfee;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}
	
	public Integer getPrescriptionId() {
		return prescriptionid;
	}
	
	public void setPrescriptionId(Integer prescriptionid) {
		this.prescriptionid = prescriptionid;
	}

	public Integer getPrescriptionAmount() {
		return prescriptionamount;
	}

	public void setPrescriptionAmount(Integer prescriptionamount) {
		this.prescriptionamount = prescriptionamount;
	}

	public LabTest getLabTest() {
		return labtest;
	}

	public void setLabTest(LabTest labtest) {
		this.labtest = labtest;
	}
	
	public Integer getLabTestno() {
		return labtestno;
	}
	
	public void setLabTestno(Integer labtestno) {
		this.labtestno = labtestno;
	}

	public Integer getLabTestPrice() {
		return labtestprice;
	}

	public void setLabtestno(Integer labtestprice) {
		this.labtestprice = labtestprice;
	}

	@Override
	public String toString() {
		return "Billing [invoiceno=" + invoiceno + ", invoiceDate=" + invoiceDate + ", totalAmount=" + totalAmount + ", status="
				+ status + ", adminstaff=" + adminstaff + ", personnelid=" + personnelid + ", patient=" + patient
				+ ", patientno=" + patientno + ", doctorConsultation=" + doctorConsultation + ", consultationid=" + consultationid + ", consultationfee="
				+ consultationfee + ", prescription=" + prescription + ", prescriptionid=" + prescriptionid + ", prescriptionamount=" + prescriptionamount
				+ ", labtest=" + labtest + ", labtestno=" + labtestno + ", labtestprice=" + labtestprice + "]";
	}
}