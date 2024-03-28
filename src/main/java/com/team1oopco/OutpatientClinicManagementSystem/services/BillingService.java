package com.team1oopco.OutpatientClinicManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1oopco.OutpatientClinicManagementSystem.models.Billing;
import com.team1oopco.OutpatientClinicManagementSystem.repositories.BillingRepository;

@Service
public class BillingService {
	
	@Autowired
	private BillingRepository billingRepository;
	
	//returning list of Doctor Consultations
	public List<Billing> getBillings(){
		return billingRepository.findAll();
	}
	
	//saving new Doctor Consultation data
	public void save(Billing billing) {
		billingRepository.save(billing);
	}
	
	public void delete(Integer invoiceno) {
		billingRepository.deleteById(invoiceno);
	}
	
	//get by consultation id
	public Optional<Billing> findById(Integer invoiceno) {
		return billingRepository.findById(invoiceno);
	}
}
