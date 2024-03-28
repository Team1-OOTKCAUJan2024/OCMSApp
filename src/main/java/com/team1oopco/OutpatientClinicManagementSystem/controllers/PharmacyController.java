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
import com.team1oopco.OutpatientClinicManagementSystem.models.DoctorConsultation;
import com.team1oopco.OutpatientClinicManagementSystem.models.MedicalStaff;
import com.team1oopco.OutpatientClinicManagementSystem.models.Pharmacy;
import com.team1oopco.OutpatientClinicManagementSystem.models.Triage;
import com.team1oopco.OutpatientClinicManagementSystem.services.AppointmentService;
import com.team1oopco.OutpatientClinicManagementSystem.services.DoctorConsultationService;
import com.team1oopco.OutpatientClinicManagementSystem.services.MedicalStaffService;
import com.team1oopco.OutpatientClinicManagementSystem.services.PharmacyService;
import com.team1oopco.OutpatientClinicManagementSystem.services.TriageService;

@Controller
public class PharmacyController {
	
	@Autowired
	private PharmacyService pharmacyService;
	
	@Autowired
	private DoctorConsultationService doctorConsultationService;
	
	@Autowired
	private MedicalStaffService medicalStaffService;
	
	@GetMapping("/pharmacy")
	public String getPharmacy(Model model) {
		
		List<Pharmacy> pharmacyList = pharmacyService.getPharmacy();
		model.addAttribute("pharmacies", pharmacyList);
		
		List<DoctorConsultation> doctorConsultationList = doctorConsultationService.getDoctorConsultations();
		model.addAttribute("consultations", doctorConsultationList);
		
		List<MedicalStaff> medicalStaffList = medicalStaffService.getMedicalStaffs();
		model.addAttribute("medicalStaffs", medicalStaffList);
		
		return "pharmacy";
	}
	
	@PostMapping("pharmacy/addNew")
	public String addNew(Pharmacy pharmacy) {
		
		pharmacyService.save(pharmacy);
		
		return "redirect:/pharmacy";
	}
	
	@RequestMapping("pharmacy/findById")
	@ResponseBody
	public Optional<Pharmacy> findById(Integer pharmacyid) {
		
		return pharmacyService.findById(pharmacyid);
	}
	
	@RequestMapping(value="pharmacy/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Pharmacy pharmacy) {
		
		pharmacyService.save(pharmacy);
		
		return "redirect:/pharmacy";
	}
	
	@RequestMapping(value="pharmacy/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer pharmacyid) {
		
		pharmacyService.delete(pharmacyid);
		
		return "redirect:/pharmacy";
	}
}
