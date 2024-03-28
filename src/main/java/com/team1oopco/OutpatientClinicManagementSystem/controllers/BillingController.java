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
import com.team1oopco.OutpatientClinicManagementSystem.models.LabTest;
import com.team1oopco.OutpatientClinicManagementSystem.models.Patient;
import com.team1oopco.OutpatientClinicManagementSystem.models.Prescription;
import com.team1oopco.OutpatientClinicManagementSystem.models.Billing;
import com.team1oopco.OutpatientClinicManagementSystem.models.AdminStaff;
import com.team1oopco.OutpatientClinicManagementSystem.services.DoctorConsultationService;
import com.team1oopco.OutpatientClinicManagementSystem.services.LabTestService;
import com.team1oopco.OutpatientClinicManagementSystem.services.PatientService;
import com.team1oopco.OutpatientClinicManagementSystem.services.PrescriptionService;
import com.team1oopco.OutpatientClinicManagementSystem.services.BillingService;
import com.team1oopco.OutpatientClinicManagementSystem.services.AdminStaffService;

@Controller
public class BillingController {
	
	@Autowired
	private BillingService billingService;
	
	@Autowired
	private DoctorConsultationService doctorConsultationService;
	
	@Autowired
	private LabTestService labTestService;
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private AdminStaffService adminStaffService;
	
	@GetMapping("/billing")
	public String getBillings(Model model) {
		
		List<Billing> billingList = billingService.getBillings();
		model.addAttribute("billings", billingList);
		
		List<DoctorConsultation> doctorConsultationList = doctorConsultationService.getDoctorConsultations();
		model.addAttribute("doctorConsultations", doctorConsultationList);
		
		List<LabTest> labTestList = labTestService.getLabTests();
		model.addAttribute("labTests", labTestList);
		
		List<Prescription> prescriptionList = prescriptionService.getPrescriptions();
		model.addAttribute("prescriptions", prescriptionList);
		
		List<Patient> patientList = patientService.getPatients();
		model.addAttribute("patients", patientList);
		
		List<AdminStaff> adminStaffList = adminStaffService.getAdminStaffs();
		model.addAttribute("adminStaffs", adminStaffList);
		
		return "billing";
	}
	
	@PostMapping("billing/addNew")
	public String addNew(Billing billing) {
		
		billingService.save(billing);
		
		return "redirect:/billing";
	}
	
	@RequestMapping("billing/findById")
	@ResponseBody
	public Optional<Billing> findById(Integer invoiceno) {
		
		return billingService.findById(invoiceno);
	}
	
	@RequestMapping(value="billing/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Billing billing) {
		
		billingService.save(billing);
		
		return "redirect:/billing";
	}
	
	@RequestMapping(value="billing/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer invoiceno) {
		
		billingService.delete(invoiceno);
		
		return "redirect:/billing";
	}
}
