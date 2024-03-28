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
import com.team1oopco.OutpatientClinicManagementSystem.services.AppointmentService;
import com.team1oopco.OutpatientClinicManagementSystem.services.DoctorConsultationService;
import com.team1oopco.OutpatientClinicManagementSystem.services.MedicalStaffService;
@Controller
public class DoctorConsultationController {

	@Autowired
	private DoctorConsultationService doctorConsultationService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private MedicalStaffService medicalStaffService;
	
	@GetMapping("/consultations")
	public String getDoctorConsultations(Model model) {
		
		List<DoctorConsultation> doctorConsultationList = doctorConsultationService.getDoctorConsultations();
		model.addAttribute("doctorConsultations", doctorConsultationList);
		
		List<Appointment> appointmentList = appointmentService.getAppointments();
		model.addAttribute("appointments", appointmentList);
		
		List<MedicalStaff> medicalStaffList = medicalStaffService.getMedicalStaffs();
		model.addAttribute("medicalStaffs", medicalStaffList);
		
		return "doctor-consultation";
	}
	
	@PostMapping("consultations/addNew")
	public String addNew(DoctorConsultation doctorConsultation) {
		
		doctorConsultationService.save(doctorConsultation);
		
		return "redirect:/consultations";
	}
	
	@RequestMapping("consultations/findById")
	@ResponseBody
	public Optional<DoctorConsultation> findById(Integer consultationid) {
		
		return doctorConsultationService.findById(consultationid);
	}
	
	@RequestMapping(value="consultations/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(DoctorConsultation doctorConsultation) {
		
		doctorConsultationService.save(doctorConsultation);
		
		return "redirect:/consultations";
	}
	
	@RequestMapping(value="consultations/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer consultationid) {
		
		doctorConsultationService.delete(consultationid);
		
		return "redirect:/consultations";
	}
}
