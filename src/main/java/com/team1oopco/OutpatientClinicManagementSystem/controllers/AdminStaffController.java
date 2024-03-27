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
import com.team1oopco.OutpatientClinicManagementSystem.services.AdminStaffService;

@Controller
public class AdminStaffController {
	
	@Autowired
	private AdminStaffService adminStaffService;
	
	@GetMapping("/adminStaff")
	public String getAdminStaffs(Model model) {
		
		List<AdminStaff> adminStaffList = adminStaffService.getAdminStaffs();
		
		model.addAttribute("adminStaffs", adminStaffList);
		
		return "admin-staff";
	}
	
	@PostMapping("adminStaff/addNew")
	public String addNew(AdminStaff adminStaff) {
		
		adminStaffService.save(adminStaff);
		
		return "redirect:/adminStaff";
	}
	
	@RequestMapping("adminStaff/findById")
	@ResponseBody
	public Optional<AdminStaff> findById(Integer personnelid) {
		
		return adminStaffService.findById(personnelid);
	}
	
	@RequestMapping(value="adminStaff/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(AdminStaff adminStaff) {
		
		adminStaffService.save(adminStaff);
		
		return "redirect:/adminStaff";
	}
	
	@RequestMapping(value="adminStaff/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer personnelid) {
		
		adminStaffService.delete(personnelid);
		
		return "redirect:/adminStaff";
	}
}
