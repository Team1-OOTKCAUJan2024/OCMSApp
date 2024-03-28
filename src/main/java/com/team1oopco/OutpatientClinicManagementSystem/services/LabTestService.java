package com.team1oopco.OutpatientClinicManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1oopco.OutpatientClinicManagementSystem.models.LabTest;
import com.team1oopco.OutpatientClinicManagementSystem.repositories.LabTestRepository;

@Service
public class LabTestService {
	@Autowired
	private LabTestRepository labTestRepository;
	
	//returning list of labTests
	public List<LabTest> getLabTests(){
		return labTestRepository.findAll();
	}
	
	//saving new labTest data
	public void save(LabTest labTest) {
		labTestRepository.save(labTest);
	}
	
	public void delete(Integer labtestno) {
		labTestRepository.deleteById(labtestno);
	}
	
	//get by labTest id
	public Optional<LabTest> findById(Integer labtestno) {
		return labTestRepository.findById(labtestno);
	}
}
