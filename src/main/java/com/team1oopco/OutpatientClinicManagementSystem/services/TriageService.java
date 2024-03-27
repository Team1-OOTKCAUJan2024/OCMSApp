package com.team1oopco.OutpatientClinicManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1oopco.OutpatientClinicManagementSystem.models.Triage;
import com.team1oopco.OutpatientClinicManagementSystem.repositories.TriageRepository;

@Service
public class TriageService {
	
	@Autowired
	private TriageRepository triageRepository;
	
	//returning list of triage
	public List<Triage> getTriages(){
		return triageRepository.findAll();
	}
	
	//saving new triage data
	public void save(Triage triage) {
		triageRepository.save(triage);
	}
	
	public void delete(Integer consultationid) {
		triageRepository.deleteById(consultationid);
	}
	
	//get by consultation id
	public Optional<Triage> findById(Integer consultationid) {
		return triageRepository.findById(consultationid);
	}
}
