package com.team1oopco.OutpatientClinicManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1oopco.OutpatientClinicManagementSystem.models.DoctorConsultation;
import com.team1oopco.OutpatientClinicManagementSystem.repositories.DoctorConsultationRepository;

@Service
public class DoctorConsultationService {
	
	@Autowired
	private DoctorConsultationRepository doctorConsultationRepository;
	
	//returning list of Doctor Consultations
	public List<DoctorConsultation> getDoctorConsultations(){
		return doctorConsultationRepository.findAll();
	}
	
	//saving new Doctor Consultation data
	public void save(DoctorConsultation doctorConsultation) {
		doctorConsultationRepository.save(doctorConsultation);
	}
	
	public void delete(Integer consultationid) {
		doctorConsultationRepository.deleteById(consultationid);
	}
	
	//get by consultation id
	public Optional<DoctorConsultation> findById(Integer consultationid) {
		return doctorConsultationRepository.findById(consultationid);
	}
}
