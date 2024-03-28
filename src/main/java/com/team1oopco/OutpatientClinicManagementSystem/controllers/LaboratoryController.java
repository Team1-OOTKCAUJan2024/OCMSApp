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

import com.team1oopco.OutpatientClinicManagementSystem.models.DoctorConsultation;
import com.team1oopco.OutpatientClinicManagementSystem.models.MedicalStaff;
import com.team1oopco.OutpatientClinicManagementSystem.models.Laboratory;
import com.team1oopco.OutpatientClinicManagementSystem.services.DoctorConsultationService;
import com.team1oopco.OutpatientClinicManagementSystem.services.MedicalStaffService;
import com.team1oopco.OutpatientClinicManagementSystem.services.LaboratoryService;

@Controller
public class LaboratoryController {
	
	@Autowired
	private LaboratoryService laboratoryService;
	
	@Autowired
	private DoctorConsultationService doctorConsultationService;
	
	@Autowired
	private MedicalStaffService medicalStaffService;
	
	@GetMapping("/laboratory")
	public String getLaboratory(Model model) {
		
		List<Laboratory> laboratoryList = laboratoryService.getLaboratory();
		model.addAttribute("laboratories", laboratoryList);
		
		List<DoctorConsultation> doctorConsultationList = doctorConsultationService.getDoctorConsultations();
		model.addAttribute("consultations", doctorConsultationList);
		
		List<MedicalStaff> medicalStaffList = medicalStaffService.getMedicalStaffs();
		model.addAttribute("medicalStaffs", medicalStaffList);
		
		return "laboratory";
	}
	
	@PostMapping("laboratory/addNew")
	public String addNew(Laboratory laboratory) {
		
		laboratoryService.save(laboratory);
		
		return "redirect:/laboratory";
	}
	
	@RequestMapping("laboratory/findById")
	@ResponseBody
	public Optional<Laboratory> findById(Integer labno) {
		
		return laboratoryService.findById(labno);
	}
	
	@RequestMapping(value="laboratory/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Laboratory laboratory) {
		
		laboratoryService.save(laboratory);
		
		return "redirect:/laboratory";
	}
	
	@RequestMapping(value="laboratory/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer labno) {
		
		laboratoryService.delete(labno);
		
		return "redirect:/laboratory";
	}
}
