package com.team1oopco.OutpatientClinicManagementSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorConsultationController {
	
	@GetMapping("/consultations")
	public String getPatients() {
		return "doctor-consultation";
	}
}
