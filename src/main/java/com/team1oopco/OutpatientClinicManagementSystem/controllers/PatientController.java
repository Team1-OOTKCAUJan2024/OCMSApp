package com.team1oopco.OutpatientClinicManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.team1oopco.OutpatientClinicManagementSystem.models.Patient;
import com.team1oopco.OutpatientClinicManagementSystem.services.PatientService;

@Controller
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/patients")
	public String getPatients(Model model) {
		
		List<Patient> patientList = patientService.getPatients();
		
		model.addAttribute("patients", patientList);
		
		return "patient";
	}
	
	@PostMapping("/patients/addNew")
	public String addNew(Patient patient) {
		
		patientService.save(patient);
		
		return "redirect:/patients";
	}
}
