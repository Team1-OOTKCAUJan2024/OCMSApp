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

import com.team1oopco.OutpatientClinicManagementSystem.models.Appointment;
import com.team1oopco.OutpatientClinicManagementSystem.models.MedicalStaff;
import com.team1oopco.OutpatientClinicManagementSystem.models.Triage;
import com.team1oopco.OutpatientClinicManagementSystem.services.AppointmentService;
import com.team1oopco.OutpatientClinicManagementSystem.services.MedicalStaffService;
import com.team1oopco.OutpatientClinicManagementSystem.services.TriageService;

@Controller
public class TriageController {
	
	@Autowired
	private TriageService triageService;
	private AppointmentService appointmentService;
	private MedicalStaffService medicalStaffService;
	
	@GetMapping("/triage")
	public String getTriages(Model model) {
		
		List<Triage> triageList = triageService.getTriages();
		model.addAttribute("triages", triageList);
		
		List<Appointment> appointmentList = appointmentService.getAppointments();
		model.addAttribute("appointments", appointmentList);
		
		List<MedicalStaff> medicalStaffList = medicalStaffService.getMedicalStaffs();
		model.addAttribute("medicalStaffs", medicalStaffList);
		
		return "triage";
	}
	
	@PostMapping("triage/addNew")
	public String addNew(Triage triage) {
		
		triageService.save(triage);
		
		return "redirect:/triages";
	}
	
	@RequestMapping("triage/findById")
	@ResponseBody
	public Optional<Triage> findById(Integer consultationid) {
		
		return triageService.findById(consultationid);
	}
	
	@RequestMapping(value="triage/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Triage triage) {
		
		triageService.save(triage);
		
		return "redirect:/triages";
	}
	
	@RequestMapping(value="triage/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer triageno) {
		
		triageService.delete(triageno);
		
		return "redirect:/triages";
	}
}
