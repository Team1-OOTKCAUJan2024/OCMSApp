package com.team1oopco.OutpatientClinicManagementSystem.services;

import java.util.List;
import java.util.Optional;

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
	
	//saving new staff
	public void save(MedicalStaff medicalStaff) {
		medicalStaffRepository.save(medicalStaff);
	}
	
	public void delete(Integer personnelid) {
		medicalStaffRepository.deleteById(personnelid);
	}
	
	//get by staff number
	public Optional<MedicalStaff> findById(Integer personnelid) {
		return medicalStaffRepository.findById(personnelid);
	}
	
}
