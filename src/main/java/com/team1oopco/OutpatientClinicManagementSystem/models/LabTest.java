package com.team1oopco.OutpatientClinicManagementSystem.models;

import java.util.Scanner;  // Import the Scanner class for user input

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime; // Import the LocalDateTime class to save dates
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class to format the time

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "labtestno")
public class LabTest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer labtestno;
	public String testName;
	private String sample;
	private String results;
	public Float testprice;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="labno", insertable=false, updatable=false)
    private Laboratory laboratory;
    private Integer labno;
    
	public LabTest(Integer labtestno, String testName, String sample, String results, Float testprice, String status, Laboratory laboratory,
			Integer labno) {
		this.labtestno = labtestno;
		this.testName = testName;
		this.sample = sample;
		this.results = results;
		this.testprice = testprice;
		this.status = status;
		this.laboratory = laboratory;
		this.labno = labno;
	}

	public LabTest() {
	}

	public Integer getLabtestno() {
		return labtestno;
	}

	public void setLabtestno(Integer labtestno) {
		this.labtestno = labtestno;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getSample() {
		return sample;
	}

	public void setSample(String sample) {
		this.sample = sample;
	}
	
	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public Float getTestprice() {
		return testprice;
	}

	public void setTestprice(Float testprice) {
		this.testprice = testprice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Laboratory getLaboratory() {
		return laboratory;
	}

	public void setLaboratory(Laboratory laboratory) {
		this.laboratory = laboratory;
	}

	public Integer getLabno() {
		return labno;
	}

	public void setLabno(Integer labno) {
		this.labno = labno;
	}

	@Override
	public String toString() {
		return "LabTest [labtestno=" + labtestno + ", testName=" + testName + ", sample=" + sample
				+ ", results=" + results + ", testprice=" + testprice + ", status=" + status + ", laboratory=" + laboratory + ", labno=" + labno + "]";
	}
     
    
    //Figure out the connection with Billing.
}
