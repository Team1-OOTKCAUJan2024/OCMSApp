package com.team1oopco.OutpatientClinicManagementSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrescriptionController {
	
	@GetMapping("/prescriptions")
	public String getPatients() {
		return "prescription";
	}
}
