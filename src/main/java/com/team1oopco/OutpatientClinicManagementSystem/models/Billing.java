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

    // Constructor
    /*public Billing(Personnel personnel, String invoiceNo, String invoiceDate, int amount, String status, Patient patient) {
        this.personnel = personnel;
        this.invoiceNo = invoiceNo;
        this.invoiceDate = invoiceDate;
        this.amount = amount;
        this.status = status;
        this.patient = patient;
    }
    // Method to generate an invoice for a patient
    public String invoicePatient(String patientName) {
        // Logic to generate the invoice for the patient
        return "Invoice generated for " + patientName;
    }

    // Method to process a payment for an invoice
    public String payInvoice() {
        // Logic to process the payment for the invoice
        return "Invoice paid successfully";
    }*/
}