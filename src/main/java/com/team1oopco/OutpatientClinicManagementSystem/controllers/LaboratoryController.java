package com.team1oopco.OutpatientClinicManagementSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LaboratoryController {
	
	@GetMapping("/laboratory")
	public String getPatients() {
		return "laboratory";
	}
}
