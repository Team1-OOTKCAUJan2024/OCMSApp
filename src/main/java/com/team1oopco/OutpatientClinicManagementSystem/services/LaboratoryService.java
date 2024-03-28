package com.team1oopco.OutpatientClinicManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1oopco.OutpatientClinicManagementSystem.models.Laboratory;
import com.team1oopco.OutpatientClinicManagementSystem.repositories.LaboratoryRepository;

@Service
public class LaboratoryService {
	@Autowired
	private LaboratoryRepository laboratoryRepository;
	
	//returning list of laboratory requests
	public List<Laboratory> getLaboratory(){
		return laboratoryRepository.findAll();
	}
	
	//saving new laboratory data
	public void save(Laboratory laboratory) {
		laboratoryRepository.save(laboratory);
	}
	
	public void delete(Integer labno) {
		laboratoryRepository.deleteById(labno);
	}
	
	//get by consultation id
	public Optional<Laboratory> findById(Integer labno) {
		return laboratoryRepository.findById(labno);
	}
}
