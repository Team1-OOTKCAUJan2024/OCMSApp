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

import com.team1oopco.OutpatientClinicManagementSystem.models.AdminStaff;
import com.team1oopco.OutpatientClinicManagementSystem.models.Appointment;
import com.team1oopco.OutpatientClinicManagementSystem.models.Patient;
import com.team1oopco.OutpatientClinicManagementSystem.services.AdminStaffService;
import com.team1oopco.OutpatientClinicManagementSystem.services.AppointmentService;
import com.team1oopco.OutpatientClinicManagementSystem.services.PatientService;

@Controller
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	private PatientService patientService;
	private AdminStaffService adminStaffService;
	
	@GetMapping("/appointments")
	public String getAppointments(Model model) {
		
		List<Appointment> appointmentList = appointmentService.getAppointments();
		model.addAttribute("appointments", appointmentList);
		
		List<Patient> patientList = patientService.getPatients();
		model.addAttribute("patients", patientList);
		
		List<AdminStaff> adminStaffList = adminStaffService.getAdminStaffs();
		model.addAttribute("adminStaffs", adminStaffList);
		
		return "appointment";
	}
	
	@PostMapping("appointments/addNew")
	public String addNew(Appointment appointment) {
		
		appointmentService.save(appointment);
		
		return "redirect:/appointments";
	}
	
	@RequestMapping("appointments/findById")
	@ResponseBody
	public Optional<Appointment> findById(Integer appointmentid) {
		
		return appointmentService.findById(appointmentid);
	}
	
	@RequestMapping(value="appointments/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Appointment appointment) {
		
		appointmentService.save(appointment);
		
		return "redirect:/appointments";
	}
	
	@RequestMapping(value="appointments/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer appointmentid) {
		
		appointmentService.delete(appointmentid);
		
		return "redirect:/appointments";
	}
}
