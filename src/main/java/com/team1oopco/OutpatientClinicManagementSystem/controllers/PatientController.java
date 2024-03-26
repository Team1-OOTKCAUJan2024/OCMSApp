package com.team1oopco.OutpatientClinicManagementSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {
	
	@GetMapping("/patients")
	public String getPatients() {
		return "patient";
	}
}
