package com.team1oopco.OutpatientClinicManagementSystem.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team1oopco.OutpatientClinicManagementSystem.models.Pharmacy;
import com.team1oopco.OutpatientClinicManagementSystem.models.Prescription;
import com.team1oopco.OutpatientClinicManagementSystem.services.PharmacyService;
import com.team1oopco.OutpatientClinicManagementSystem.services.PrescriptionService;

@Controller
public class PrescriptionController {
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	@Autowired
	private PharmacyService pharmacyService;

	
	@GetMapping("/prescriptions")
	public String getPrescriptions(Model model) {
		
		List<Prescription> prescriptionList = prescriptionService.getPrescriptions();
		model.addAttribute("prescriptions", prescriptionList);
		
		List<Pharmacy> pharmacyList = pharmacyService.getPharmacy();
		model.addAttribute("pharmacies", pharmacyList);
		
		return "prescription";
	}
	
	@PostMapping("prescriptions/addNew")
	public String addNew(Prescription prescription) {
		
		prescriptionService.save(prescription);
		
		return "redirect:/prescriptions";
	}
	
	@RequestMapping("prescriptions/findById")
	@ResponseBody
	public Optional<Prescription> findById(Integer prescriptionid) {
		
		return prescriptionService.findById(prescriptionid);
	}
	
	@RequestMapping(value="prescriptions/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Prescription prescription) {
		
		prescriptionService.save(prescription);
		
		return "redirect:/prescriptions";
	}
	
	@RequestMapping(value="prescriptions/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer prescriptionid) {
		
		prescriptionService.delete(prescriptionid);
		
		return "redirect:/prescriptions";
	}
}
