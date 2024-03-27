package com.team1oopco.OutpatientClinicManagementSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1oopco.OutpatientClinicManagementSystem.models.MedicalStaff;
import com.team1oopco.OutpatientClinicManagementSystem.repositories.MedicalStaffRepository;

@Service
public class MedicalStaffService {
	@Autowired
	private MedicalStaffRepository medicalStaffRepository;
	
	//returning list of medical staff
	public List<MedicalStaff> getMedicalStaffs(){
		return medicalStaffRepository.findAll();
	}
}
