package com.team1oopco.OutpatientClinicManagementSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1oopco.OutpatientClinicManagementSystem.models.Appointment;
import com.team1oopco.OutpatientClinicManagementSystem.repositories.AppointmentRepository;

@Service
public class AppointmentService {
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	//returning list of appointments
	public List<Appointment> getAppointments(){
		return appointmentRepository.findAll();
	}
}
