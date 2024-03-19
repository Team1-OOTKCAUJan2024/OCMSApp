package com.team1oopco.OutpatientClinicManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team1oopco.OutpatientClinicManagementSystem.models.DoctorConsultation;

@Repository
public interface DoctorConsultationRepository extends JpaRepository<DoctorConsultation, Integer> {

}
