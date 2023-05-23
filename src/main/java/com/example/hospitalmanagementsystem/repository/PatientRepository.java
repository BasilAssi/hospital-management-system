package com.example.hospitalmanagementsystem.repository;

import com.example.hospitalmanagementsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Long> {


}
