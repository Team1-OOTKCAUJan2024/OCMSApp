package com.team1oopco.OutpatientClinicManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1oopco.OutpatientClinicManagementSystem.models.Pharmacy;
import com.team1oopco.OutpatientClinicManagementSystem.repositories.PharmacyRepository;

@Service
public class PharmacyService {
	@Autowired
	private PharmacyRepository pharmacyRepository;
	
	//returning list of pharmacy requests
	public List<Pharmacy> getPharmacy(){
		return pharmacyRepository.findAll();
	}
	
	//saving new pharmacy data
	public void save(Pharmacy pharmacy) {
		pharmacyRepository.save(pharmacy);
	}
	
	public void delete(Integer pharmacyid) {
		pharmacyRepository.deleteById(pharmacyid);
	}
	
	//get by consultation id
	public Optional<Pharmacy> findById(Integer pharmacyid) {
		return pharmacyRepository.findById(pharmacyid);
	}
}
