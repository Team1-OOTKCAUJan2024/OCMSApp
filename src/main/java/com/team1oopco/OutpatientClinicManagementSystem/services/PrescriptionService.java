package com.team1oopco.OutpatientClinicManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1oopco.OutpatientClinicManagementSystem.models.Prescription;
import com.team1oopco.OutpatientClinicManagementSystem.repositories.PrescriptionRepository;

@Service
public class PrescriptionService {

	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	//returning list of prescriptions
	public List<Prescription> getPrescriptions(){
		return prescriptionRepository.findAll();
	}
	
	//saving new prescription data
	public void save(Prescription prescription) {
		prescriptionRepository.save(prescription);
	}
	
	public void delete(Integer prescriptionid) {
		prescriptionRepository.deleteById(prescriptionid);
	}
	
	//get by prescription id
	public Optional<Prescription> findById(Integer prescriptionid) {
		return prescriptionRepository.findById(prescriptionid);
	}
}
