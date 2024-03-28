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

import com.team1oopco.OutpatientClinicManagementSystem.models.MedicalStaff;
import com.team1oopco.OutpatientClinicManagementSystem.services.MedicalStaffService;

@Controller
public class MedicalStaffController {
	
	@Autowired
	private MedicalStaffService medicalStaffService;
	
	@GetMapping("/medicalStaff")
	public String getMedicalStaffs(Model model) {
		
		List<MedicalStaff> medicalStaffList = medicalStaffService.getMedicalStaffs();
		
		model.addAttribute("medicalStaffs", medicalStaffList);
		
		return "medical-staff";
	}
	
	@PostMapping("medicalStaff/addNew")
	public String addNew(MedicalStaff medicalStaff) {
		
		medicalStaffService.save(medicalStaff);
		
		return "redirect:/medicalStaff";
	}
	
	@RequestMapping("medicalStaff/findById")
	@ResponseBody
	public Optional<MedicalStaff> findById(Integer personnelid) {
		
		return medicalStaffService.findById(personnelid);
	}
	
	@RequestMapping(value="medicalStaff/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(MedicalStaff medicalStaff) {
		
		medicalStaffService.save(medicalStaff);
		
		return "redirect:/medicalStaff";
	}
	
	@RequestMapping(value="medicalStaff/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer personnelid) {
		
		medicalStaffService.delete(personnelid);
		
		return "redirect:/medicalStaff";
	}
}
