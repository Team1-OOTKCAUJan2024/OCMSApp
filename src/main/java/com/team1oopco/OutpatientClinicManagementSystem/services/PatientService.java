package com.team1oopco.OutpatientClinicManagementSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1oopco.OutpatientClinicManagementSystem.models.Patient;
import com.team1oopco.OutpatientClinicManagementSystem.repositories.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	//returning list of patients
	public List<Patient> getPatients(){
		return patientRepository.findAll();
	}
	
	//saving new patient
	public void save(Patient patient) {
		patientRepository.save(patient);
	}
}
