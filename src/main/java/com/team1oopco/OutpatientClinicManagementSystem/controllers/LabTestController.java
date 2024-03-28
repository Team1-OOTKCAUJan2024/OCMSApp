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

import com.team1oopco.OutpatientClinicManagementSystem.models.Laboratory;
import com.team1oopco.OutpatientClinicManagementSystem.models.LabTest;
import com.team1oopco.OutpatientClinicManagementSystem.services.LaboratoryService;
import com.team1oopco.OutpatientClinicManagementSystem.services.LabTestService;

@Controller
public class LabTestController {
	
	@Autowired
	private LabTestService labTestService;
	
	@Autowired
	private LaboratoryService laboratoryService;

	
	@GetMapping("/labTests")
	public String getLabTests(Model model) {
		
		List<LabTest> labTestList = labTestService.getLabTests();
		model.addAttribute("labTests", labTestList);
		
		List<Laboratory> laboratoryList = laboratoryService.getLaboratory();
		model.addAttribute("laboratories", laboratoryList);
		
		return "lab-test";
	}
	
	@PostMapping("labTests/addNew")
	public String addNew(LabTest labTest) {
		
		labTestService.save(labTest);
		
		return "redirect:/labTests";
	}
	
	@RequestMapping("labTests/findById")
	@ResponseBody
	public Optional<LabTest> findById(Integer labtestno) {
		
		return labTestService.findById(labtestno);
	}
	
	@RequestMapping(value="labTests/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(LabTest labTest) {
		
		labTestService.save(labTest);
		
		return "redirect:/labTests";
	}
	
	@RequestMapping(value="labTests/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer labtestno) {
		
		labTestService.delete(labtestno);
		
		return "redirect:/labTests";
	}
}
