package com.team1oopco.OutpatientClinicManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team1oopco.OutpatientClinicManagementSystem.models.Laboratory;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Integer> {

}
