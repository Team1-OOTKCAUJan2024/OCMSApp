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
	
	@RequestMapping("patients/findById")
	@ResponseBody
	public Optional<Patient> findById(Integer patientno) {
		
		return patientService.findById(patientno);
	}
	
	@RequestMapping(value="/patients/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Patient patient) {
		
		patientService.save(patient);
		
		return "redirect:/patients";
	}
}
