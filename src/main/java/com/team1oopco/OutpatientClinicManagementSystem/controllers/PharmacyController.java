package com.team1oopco.OutpatientClinicManagementSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PharmacyController {
	
	@GetMapping("/pharmacy")
	public String getPatients() {
		return "pharmacy";
	}
}
