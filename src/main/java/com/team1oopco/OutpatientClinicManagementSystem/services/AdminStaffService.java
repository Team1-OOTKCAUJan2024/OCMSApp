package com.team1oopco.OutpatientClinicManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1oopco.OutpatientClinicManagementSystem.models.AdminStaff;
import com.team1oopco.OutpatientClinicManagementSystem.repositories.AdminStaffRepository;

@Service
public class AdminStaffService {
	
	@Autowired
	private AdminStaffRepository adminStaffRepository;
	
	//returning list of patients
	public List<AdminStaff> getAdminStaffs(){
		return adminStaffRepository.findAll();
	}
	
	//saving new patient
	public void save(AdminStaff adminStaff) {
		adminStaffRepository.save(adminStaff);
	}
	
	public void delete(Integer personnelid) {
		adminStaffRepository.deleteById(personnelid);
	}
	
	//get by patient number
	public Optional<AdminStaff> findById(Integer personnelid) {
		return adminStaffRepository.findById(personnelid);
	}
}
